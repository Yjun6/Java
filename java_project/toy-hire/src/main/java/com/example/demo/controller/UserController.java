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
import java.time.LocalDateTime;
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
        return ResultAjax.succ(userinfo);
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

        @Transactional
    @PostMapping("/hirereturn")
    public ResultAjax hirereTurn(String toyid,String date,String returntoy,HttpServletRequest request) {
            System.out.println("11111");
        return null;
        }

//    @Transactional
//    @PostMapping("/hirereturn")
//    public ResultAjax hirereTurn(Integer toyid,LocalDateTime date,Integer returntoy,HttpServletRequest request) {
//        System.out.println("111");
////        "toyid": toyid,
////                "date": date,
////                "returntoy": returntoy
//        System.out.println(toyid);
//        System.out.println(date);
//        System.out.println(returntoy);
//        //1.验证登录
//        Userinfo userinfo = SessionUtils.getUser(request);
//        if (userinfo==null) {
//            return ResultAjax.fail(-2,"请先登录");
//        }
//        //2.验证是否可以归还
//        if (toyid==null || date==null || returntoy==null) {
//            return ResultAjax.fail(-1,"参数有误");
//        }
//        int ret = allService.getHireUser(userinfo.getId(),toyid,date);
//        if (ret < returntoy) {
//            return ResultAjax.fail(-1,"参数有误");
//        }
//        //3.归还
//        int r = 1;
//        try{
//            //玩具增加
//            Toyinfo toyinfo = new Toyinfo();
//            toyinfo.setInventory(toyinfo.getInventory()+returntoy);
//            toyinfo.setId(toyid);
//            FutureTask<Integer> addToyById = new FutureTask(()->{
//                return toyService.addToyById(toyinfo);
//            });
//            taskExecutor.submit(addToyById);
//            ret = addToyById.get();
//            if (ret != 1) {
//                return ResultAjax.fail(-1,"归还失败");
//            }
//            //hireuser  state=0
//            HireUserinfo hireUserinfo = new HireUserinfo();
//            hireUserinfo.setUserid(userinfo.getId());
//            hireUserinfo.setToyid(toyid);
//            hireUserinfo.setState(0);
//            hireUserinfo.setCreatetime(date);
//            int returnToy = returntoy;
//            for (int i = 0; i < returnToy; i++) {
//                FutureTask<Integer> updateState = new FutureTask(()->{
//                    return hireUserService.updateState(hireUserinfo);
//                });
//                taskExecutor.submit(updateState);
//                r = updateState.get();
//                if(r != 1) {
//                    //插入失败
//                    return ResultAjax.fail(-1,"归还失败");
//                }
//            }
//            return ResultAjax.succ(1);
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            if (ret != 1 || r != 1) {
//                throw new RuntimeException("玩具归还失败");
//            }
//        }
//        return ResultAjax.fail(-1,"参数有误");
//    }

}
