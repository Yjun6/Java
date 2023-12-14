package com.example.demo.controller;

import com.example.demo.common.ResultAjax;
import com.example.demo.common.SessionUtils;
import com.example.demo.model.*;
import com.example.demo.service.HireUserService;
import com.example.demo.service.ToyService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.concurrent.ExecutionException;

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

    @RequestMapping("/hire")
    public ResultAjax hireToy(String toyname,String number, String type, HttpServletRequest request) throws ExecutionException, InterruptedException {
        HireUserinfo hireUser = new HireUserinfo();
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
        Toyinfo toyinfo = toyService.selectToyByName(toyname);
        if (toyinfo.getInventory()<=0) {
            return ResultAjax.fail(-1,"玩具库存不足，租借失败");
        }
        //查询用户当前使用支付的方式，是否可以满足支付
        int price = toyinfo.getPrice();
        if (type.equals("cash") && (price/5 > userinfo.getCash())) {
            return ResultAjax.fail(-1,"当前金额余额不足");
        }else if(type.equals("points")&& (price/4 > userinfo.getPoints())){
            return ResultAjax.fail(-1,"当前点数余额不足");
        } else {
            return ResultAjax.fail(-1,"参数错误");
        }
        //3.并发
        //构建Hireuser
        hireUser.setUserid(userinfo.getId());
        hireUser.setToyid(toyinfo.getId());
        long timestamp = System.currentTimeMillis();
        Instant instant = Instant.ofEpochMilli(timestamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        hireUser.setCreatetime(localDateTime);
        hireUser.setState(1);
        //租借玩具 用户id 和玩具id insertHireUser
        int ret = hireUserService.insertHireUser(hireUser);
        //数据库里玩具数量-1
//        FutureTask<List<Articleinfo>> userTask = new FutureTask(()->{
//            return articleService.getListByUid(userinfo.getId());
//        });
//        taskExecutor.submit(userTask);
//        List<Articleinfo> list = userTask.get();
        return ResultAjax.succ(1);
    }
}
