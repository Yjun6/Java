package com.example.demo.controller;

import com.example.demo.common.ResultAjax;
import com.example.demo.common.SessionUtils;
import com.example.demo.model.*;
import com.example.demo.service.HireUserService;
import com.example.demo.service.ToyService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import com.example.demo.model.HireUserinfo;

@RestController
@RequestMapping("/toy")
public class ToyController {
    @Autowired
    private ToyService toyService;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    private UserService userService;

    @Autowired
    private HireUserService hireUserService;

    @Transactional
    @RequestMapping("/init")
    public ResultAjax getToyList(HttpServletRequest request) {
        //判断是否登录
        Managerinfo managerinfo = SessionUtils.getManager(request);
        if (managerinfo==null) {
            return ResultAjax.fail(-2,"请先登录！");
        }
        List<Toyinfo> list = toyService.getToyAll();
        return ResultAjax.succ(list);
    }

    @Transactional
    @RequestMapping("/add")
    public ResultAjax addToy(Toyinfo toyinfo, HttpServletRequest request) {
        //1.判断是否登录
        Managerinfo managerinfo = SessionUtils.getManager(request);
        if (managerinfo==null) {
            return ResultAjax.fail(-2,"请先登录！");
        }
        //2.参数校验
        if (toyinfo==null || !StringUtils.hasLength(toyinfo.getName())
                || !StringUtils.hasLength(toyinfo.getSituation())) {
            return ResultAjax.fail(-1,"非法参数");
        }
        //3.保存到数据库中
        int ret = toyService.addToy(toyinfo);
        return ResultAjax.succ(ret);
    }

    @Transactional
    /**删除玩具*/
    @RequestMapping("/del")
    public ResultAjax del(Integer id, HttpServletRequest request) {
        //1.参数校验
        if (id==null || id<=0) {
            return ResultAjax.fail(-1,"参数错误!");
        }
        //2.得到当前登录的用户
        Managerinfo managerinfo = SessionUtils.getManager(request);
        if (managerinfo == null) {
            return ResultAjax.fail(-1,"请先登录");
        }
        //3.删除操作
        int ret = toyService.del(id);
        //5.将结果返回给前端
        return ResultAjax.succ(ret);
    }

    @RequestMapping("/detail")
    public ResultAjax getToyById(Integer id, HttpServletRequest request) {
        //判断是否登录
        Managerinfo managerinfo = SessionUtils.getManager(request);
        if (managerinfo==null) {
            return ResultAjax.fail(-2,"请先登录！");
        }
        //验证id是否合法
        if (id==null || id <= 0) {
            return ResultAjax.fail(-1,"非法参数");
        }
        //根据Id查询玩具
        Toyinfo toyinfo = toyService.getToyById(id);
        return ResultAjax.succ(toyinfo);
    }

    @Transactional
    @RequestMapping("/save")
    public ResultAjax updateToyById(Toyinfo toyinfo, HttpServletRequest request) {
        //1.判断是否登录
        Managerinfo managerinfo = SessionUtils.getManager(request);
        if (managerinfo==null) {
            return ResultAjax.fail(-2,"请先登录！");
        }
        //2.参数校验
        if (toyinfo==null || !StringUtils.hasLength(toyinfo.getName())
                || !StringUtils.hasLength(toyinfo.getSituation())) {
            return ResultAjax.fail(-1,"非法参数");
        }
        //3.校验id是否存在
        Integer ret = toyService.selectToyById(toyinfo.getId());
        if (ret==null || ret<=0) {
            return ResultAjax.fail(-1,"非法参数");
        }
        //4.根据Id修改信息
        ret = toyService.updateToyById(toyinfo);
        return ResultAjax.succ(ret);
    }

    @Transactional
    @RequestMapping("/hire")
    public ResultAjax hireToy(String toyname,String number, String type, HttpServletRequest request) throws ExecutionException, InterruptedException {
        //验证数据是否有误
        if (toyname==null || type==null || number==null) {
            return ResultAjax.fail(-1,"参数错误");
        }
        //1，判断是否登录
        Userinfo userinfo = SessionUtils.getUser(request);
        if (userinfo == null) {
            return ResultAjax.fail(-2,"请先登录");
        }
        //2.查找玩具是否可借
        int num = Integer.parseInt(number);//借玩具的个数
        Toyinfo toyinfo = toyService.selectToyByName(toyname);
        if (toyinfo.getInventory()<num) {
            return ResultAjax.fail(-1,"玩具库存不足，租借失败");
        }
        //查询用户当前使用支付的方式，是否可以满足支付
        Integer price = toyinfo.getPrice();
        if (price==null || userinfo.getCash()==null || userinfo.getPoints()==null) {
            return ResultAjax.fail(-1,"玩具价格或用户余额有误");
        }
        if ("cash".equals(type) && ((price/5)*num > userinfo.getCash())) {
            return ResultAjax.fail(-1,"当前金额余额不足");
        }else if("points".equals(type) && ((price/4)*num > userinfo.getPoints())){
            return ResultAjax.fail(-1,"当前点数余额不足");
        } else if (!"cash".equals(type) && !"points".equals(type)){
            return ResultAjax.fail(-1,"参数错误");
        }
        //3.并发
        //构建Hireuser
        HireUserinfo hireUser = new HireUserinfo();
        hireUser.setUserid(userinfo.getId());
        hireUser.setToyid(toyinfo.getId());
        long timestamp = System.currentTimeMillis();
        Instant instant = Instant.ofEpochMilli(timestamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        hireUser.setCreatetime(localDateTime);
        hireUser.setState(1);
        Integer insert = 1;
        Integer update = 1;
        Integer cost = 1;
        try{
            //注意回滚数据问题
            //1)把hireuser插入数据库  只插入一次
            //2)数据库里玩具数量-num  一次性全部将数据库的玩具库存-num
            FutureTask<Integer> updateToyInventory = new FutureTask(()->{
                return toyService.updateToyInventory(toyinfo.getId(),toyinfo.getInventory()-num);
            });
            //3)扣除用户的点数或者金额  一次性全部扣费完
            FutureTask<Integer> updateUserCost;
            if (type.equals("cash")) {
                //&& (price/5 > userinfo.getCash())
                updateUserCost = new FutureTask<>(()->{
                    return userService.updateUserByIdCash(userinfo.getId(),userinfo.getCash()-(price/5)*num);
                });
            } else {
                //&& (price/4 > userinfo.getPoints())
                updateUserCost = new FutureTask<>(()->{
                    return userService.updateUserByIdPoints(userinfo.getId(),userinfo.getPoints()-(price/4)*num);
                });
            }
            //添加任务
            taskExecutor.submit(updateToyInventory);
            taskExecutor.submit(updateUserCost);
            //循环插入租借数据到数据库里面
//            1)把hireuser插入数据库  只插入一次
            System.out.println(num);
            for (int i = 0; i < num; i++) {
                FutureTask<Integer> insertHireUserTask = new FutureTask(()->{
                    return hireUserService.insertHireUser(hireUser);
                });
                taskExecutor.submit(insertHireUserTask);
                insert = insertHireUserTask.get();
                System.out.println(insert);
                if(insert != 1) {
                    //插入失败
                    return ResultAjax.fail(-1,"租借失败");
                }
            }

            update = updateToyInventory.get();
            cost = updateUserCost.get();
            if (insert != 1 || update != 1 || cost != 1) {
                return ResultAjax.fail(-1,"租借失败");
            } else {
                return ResultAjax.succ(1);
            }
        }finally {
            if (insert != 1 || update != 1 || cost != 1) {
                throw new RuntimeException("Rollback transaction");
            }
        }
    }

}
