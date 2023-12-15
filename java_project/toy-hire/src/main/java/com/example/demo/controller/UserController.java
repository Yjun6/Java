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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

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
    public ResultAjax getToyListByInventory() {
        List<Toyinfo> list = toyService.getToyListByInventory();
        return ResultAjax.succ(list);
    }

    @RequestMapping("/hireinit")
    public ResultAjax hireInit(HttpServletRequest request) {
//        createHtml += '<tr><td>'+hiretoy.toyname+'</td>';
//        createHtml += '<td>'+hiretoy.number+'</td>';
//        createHtml += '<td>'+hiretoy.date+'</td>';
//        createHtml += '<td>'+hiretoy.latedate+'</td></tr>';
        //1.验证是否登录
        Userinfo userinfo = SessionUtils.getUser(request);
        if (userinfo==null) {
            return ResultAjax.fail(-2,"请先登录");
        }
        //2.获取hireuser state=1信息
        List<HireUserVO> list = allService.getHireUserVOById(userinfo.getId(),1);
        //设置 latedate 属性
        //        LocalDateTime now = LocalDateTime.now();
        //// 假设overdueDateTime是从数据库获取到的逾期时间
        //        LocalDateTime overdueDateTime =  "2023-12-15T13:10:09.220"; // 从数据库获取逾期时间的具体实现取决于你使用的数据库框架
        //// 计算逾期时间与当前时间之间的差值
        //        Duration duration = Duration.between(now, overdueDateTime);
        //// 获取小时数
        //        long hoursDifference = duration.toHours();

        return ResultAjax.succ(1);
    }

}
