package com.example.demo.controller;

import com.example.demo.common.AppVariable;
import com.example.demo.common.PasswordUtils;
import com.example.demo.common.ResultAjax;
import com.example.demo.common.SessionUtils;
import com.example.demo.model.HireUserinfo;
import com.example.demo.model.Managerinfo;
import com.example.demo.model.Toyinfo;
import com.example.demo.model.Userinfo;
import com.example.demo.model.vo.HireUserVO;
import com.example.demo.service.AllService;
import com.example.demo.service.HireUserService;
import com.example.demo.service.ToyService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@RestController
@RequestMapping("/user")
//@Configuration
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    private ToyService toyService;

    @Autowired
    private HireUserService hireUserService;

    @Autowired
    private AllService allService;

    /**
     * 注册功能
     * */
    @RequestMapping("/reg")
    public ResultAjax reg(Userinfo userinfo) {
        //1.校验参数
        if (userinfo == null
                || !StringUtils.hasLength(userinfo.getUsername())
                || !StringUtils.hasLength(userinfo.getPassword())
                || !StringUtils.hasLength(userinfo.getEmail())
                || !StringUtils.hasLength(userinfo.getPhone())
                || !StringUtils.hasLength(userinfo.getAddress())) {
            return ResultAjax.fail(-1,"非法参数");
        }
        //先将密码进行加盐加密
        userinfo.setPassword(PasswordUtils.encrypt(userinfo.getPassword()));
        //2.请求service进行添加参数
        int result = userService.reg(userinfo);
        //3.执行结果返回给前端
        return ResultAjax.succ(result);
    }


    /**
     * 登录接口
     * */
    @RequestMapping("/login")
    public ResultAjax login(Userinfo userinfo, HttpServletRequest request) {
        //1.参数校验
        if (userinfo==null
                || !StringUtils.hasLength(userinfo.getUsername())
                || !StringUtils.hasLength(userinfo.getPassword())) {
            //非法登录
            return ResultAjax.fail(-1,"非法登录");
        }
        //2.根据用户名(唯一的)查询对象
        Userinfo userinfotmp = userService.getUserByName(userinfo.getUsername());
        if (userinfotmp==null || userinfotmp.getId()==0) {
            //此用户不存在
            return ResultAjax.fail(-2,"用户名或密码错误");
        }
        //3.使用对象中的密码和用户输入的密码进行比较
        //加盐验证
        if (!PasswordUtils.decrypt(userinfo.getPassword(),userinfotmp.getPassword())){
            //密码错误
            return ResultAjax.fail(-1,"用户名或密码错误");
        }
        //4.设置session
        HttpSession session = request.getSession();
        session.setAttribute(AppVariable.SESSION_USERINFO_KEY,userinfotmp);
        //5.将结果返回给用户
        return ResultAjax.succ(1);
    }


    @RequestMapping("/init")
    public ResultAjax getUser(HttpServletRequest request) {
        //判断是否登录
        Userinfo userinfo = SessionUtils.getUser(request);
        if (userinfo==null) {
            return ResultAjax.fail(-2,"请先登录！");
        }
        //查询用户个人信息 并返回
        Userinfo userinfo1 = userService.getUserByName(userinfo.getUsername());
        return ResultAjax.succ(userinfo1);
    }

    @RequestMapping("/detail")
    public ResultAjax getUserDetailInit(Integer id,HttpServletRequest request) {
        if (id == null || id <= 0) {
            return ResultAjax.fail(-1,"参数有误");
        }
        //判断是否登录
        Userinfo userinfo = SessionUtils.getUser(request);
        if (userinfo==null) {
            return ResultAjax.fail(-2,"请先登录！");
        }
        System.out.println(userinfo.getId() + "   " + id);
        if (!userinfo.getId().equals(id)) {
            return ResultAjax.fail(-1,"参数有误");
        }
        //查询用户个人信息 并返回
        return ResultAjax.succ(userinfo);
    }


    /**
     * 注销
     * */
    @RequestMapping("/logout")
    public ResultAjax logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session!=null && session.getAttribute(AppVariable.SESSION_USERINFO_KEY)!=null) {
            session.removeAttribute(AppVariable.SESSION_USERINFO_KEY);
        }
        return ResultAjax.succ(1);
    }

    @RequestMapping("/save")
    public ResultAjax updateUserById(Userinfo userinfo, HttpServletRequest request) {
        //1.判断是否登录
        Userinfo userinfo1 = SessionUtils.getUser(request);
        if (userinfo1==null) {
            return ResultAjax.fail(-2,"请先登录！");
        }
        //2.参数校验
        if (userinfo1==null || !StringUtils.hasLength(userinfo1.getUsername())
                || !StringUtils.hasLength(userinfo1.getAddress())
                || !StringUtils.hasLength(userinfo1.getPhone())
                || !StringUtils.hasLength(userinfo1.getEmail())) {
            return ResultAjax.fail(-1,"非法参数");
        }
        //3.校验id是否存在
        Integer ret = userService.getUserById(userinfo.getId());
        System.out.println("ret "+ret+"  userinfo.getId() "+userinfo.getId()+"  userinfo1.getId()"+userinfo1.getId());
//        System.out.println(ret == null);
//        System.out.println(ret <= 0);
//        System.out.println(userinfo.getId().equals(userinfo1.getId()));
        if (ret == null || ret <= 0  || !userinfo.getId().equals(userinfo1.getId())){
            return ResultAjax.fail(-1,"参数错误");
        }
        //修改
        int result = userService.updateUserById(userinfo);
        System.out.println(result);
        return ResultAjax.succ(result);
    }

    @RequestMapping("/toyinit")
    public ResultAjax getToyListByInventory(HttpServletRequest request) {
        Userinfo userinfo = SessionUtils.getUser(request);
        if (userinfo==null) {
            return ResultAjax.fail(-2,"请先登录");
        }
        List<Toyinfo> list = toyService.getToyListByInventory();
        return ResultAjax.succ(list);
    }

    @RequestMapping("/hireinit")
    public ResultAjax hireInit(HttpServletRequest request) {
        //1.验证是否登录
        Userinfo userinfo = SessionUtils.getUser(request);
        if (userinfo==null) {
            return ResultAjax.fail(-2,"请先登录");
        }
        //2.获取hireuser state=1信息
        List<HireUserVO> list = allService.getHireUserVOById(userinfo.getId(),1);
        //设置 latedate 属性
        for(int i = 0; i<list.size(); i++) {
            HireUserVO h = list.get(i);
            LocalDateTime now = LocalDateTime.now();//系统当前时间
            LocalDateTime overdueDateTime = h.getDate();//玩具被借时间
            Duration duration = Duration.between(now, overdueDateTime);
//            获取小时数
            long hoursDifference = duration.toHours();
            list.get(i).setLatedate(14-(int)(hoursDifference/24));
        }

        return ResultAjax.succ(list);
    }

    /**
     * 用户归还玩具
     * ************未完成的功能：
     * ******--如果是没有逾期 点数就增加原有玩具价格的
     * *****-- 逾期了，就扣除原价格的1/10 一天算
     * */
    @Transactional
    @PostMapping("/hirereturn")
    public ResultAjax hirereTurn(String toyid,String date,String number,HttpServletRequest request) {
        System.out.println("111");
        System.out.println(toyid);
        System.out.println(date);
        System.out.println(number);
        //1.验证登录
        Userinfo userinfo = SessionUtils.getUser(request);
        if (userinfo==null) {
            return ResultAjax.fail(-2,"请先登录");
        }
        //2.验证是否可以归还
        if (toyid==null || date==null || number==null) {
            return ResultAjax.fail(-1,"参数有误");
        }
        int toyidInt = Integer.parseInt(toyid);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        int returntoyInt = Integer.parseInt(number);
        int ret = allService.getHireUser(userinfo.getId(),toyidInt,dateTime);
        if (ret != returntoyInt) {
            return ResultAjax.fail(-1,"参数有误");
        }
        //3.归还
        int r = 1;
        try{
            //1.玩具增加
            //需要先获取当前玩具信息
            Toyinfo toyinfo = toyService.selectToyByIdAll(toyidInt);
            toyinfo.setInventory(toyinfo.getInventory()+returntoyInt);
            toyinfo.setId(toyidInt);
            FutureTask<Integer> addToyById = new FutureTask(()->{
                return toyService.addToyById(toyinfo);
            });
            taskExecutor.submit(addToyById);
            ret = addToyById.get();
            if (ret != 1) {
                return ResultAjax.fail(-1,"归还失败");
            }
            //2.hireuser  state=0 归还时间updatetime
            long timestamp = System.currentTimeMillis();
            Instant instant = Instant.ofEpochMilli(timestamp);
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            HireUserinfo hireUserinfo = new HireUserinfo();
            hireUserinfo.setUserid(userinfo.getId());
            hireUserinfo.setToyid(toyidInt);
            hireUserinfo.setState(0);
            hireUserinfo.setCreatetime(dateTime);
            hireUserinfo.setUpdatetime(localDateTime);
            int returnToy = returntoyInt;
//            for (int i = 0; i < returnToy; i++) {
            FutureTask<Integer> updateState = new FutureTask(()->{
                return hireUserService.updateState(hireUserinfo);
            });
            taskExecutor.submit(updateState);
            r = updateState.get();
            if(r != returntoyInt) {
                //插入失败
                return ResultAjax.fail(-1,"归还失败");
            }
//            }
            return ResultAjax.succ(1);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (ret != 1 || r != returntoyInt) {
                System.out.println("ret:  "+ret+"  r:  "+r);
                throw new RuntimeException("玩具归还失败");
            }
        }
        return ResultAjax.fail(-1,"参数有误");
    }

    @RequestMapping("/returninit")
    public ResultAjax returnInit(HttpServletRequest request) {
        //1.验证是否登录
        Userinfo userinfo = SessionUtils.getUser(request);
        if (userinfo == null) {
            return ResultAjax.fail(-2,"请先登录");
        }
        //2.获取数据并返回
        List<HireUserVO> hireUserVOList = allService.getReturnAllById(userinfo.getId());
        return ResultAjax.succ(hireUserVOList);
    }
}
