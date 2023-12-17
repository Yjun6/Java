package com.example.demo.controller;

import com.example.demo.common.AppVariable;
import com.example.demo.common.PasswordUtils;
import com.example.demo.common.ResultAjax;
import com.example.demo.common.SessionUtils;
import com.example.demo.dao.UserMapper;
import com.example.demo.model.*;
import com.example.demo.model.vo.HireUserVO;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @Autowired
    private CaptchaService captchaService;

    @Autowired
    private UserService userService;

    @Autowired
    private HireUserService hireUserService;

    @Autowired
    private AllService allService;

    /**
     * 注册功能
     */
    @RequestMapping("/reg")
    public ResultAjax reg(Managerinfo managerinfo, Captchainfo captchainfo) {
        //1.校验参数
        if (managerinfo == null
                || !StringUtils.hasLength(managerinfo.getUsername())
                || !StringUtils.hasLength(managerinfo.getPassword())
                || !StringUtils.hasLength(captchainfo.getCaptcha())) {
            return ResultAjax.fail(-1, "非法参数");
        }
        //2.验证验证码是否正确
        String captchatmp = captchaService.selectcaptcha();
        //手动插入一个验证码
        if (captchatmp == null) {
            captchatmp = PasswordUtils.encrypt("12023");
            //插入进去
            captchaService.insertcaptcha(captchatmp);
            captchatmp = captchaService.selectcaptcha();
        }
        boolean result = PasswordUtils.decrypt(captchainfo.getCaptcha(), captchatmp);
        if (!result) {
            return ResultAjax.fail(-1, "验证码错误");
        }
        //先将密码进行加盐加密
        managerinfo.setPassword(PasswordUtils.encrypt(managerinfo.getPassword()));
        //3.请求service进行添加参数
        int ret = managerService.reg(managerinfo);
        //4.执行结果返回给前端
        return ResultAjax.succ(ret);
    }

    /**
     * 登录接口
     * */
    @RequestMapping("/login")
    public ResultAjax login(Managerinfo managerinfo, HttpServletRequest request) {
        //1.参数校验
        if (managerinfo==null
                || !StringUtils.hasLength(managerinfo.getUsername())
                || !StringUtils.hasLength(managerinfo.getPassword())) {
            //非法登录
            return ResultAjax.fail(-1,"非法登录");
        }
        //2.根据用户名(唯一的)查询对象
        Managerinfo managerinfotmp = managerService.getManagerByName(managerinfo.getUsername());
        if (managerinfotmp==null || managerinfotmp.getId()==0) {
            //此用户不存在
            return ResultAjax.fail(-2,"用户名或密码错误");
        }
        //3.使用对象中的密码和用户输入的密码进行比较
        //加盐验证
        if (!PasswordUtils.decrypt(managerinfo.getPassword(),managerinfotmp.getPassword())){
            //密码错误
            return ResultAjax.fail(-1,"用户名或密码错误");
        }
        //4.设置session
        HttpSession session = request.getSession();
        session.setAttribute(AppVariable.SESSION_USERINFO_KEY,managerinfotmp);
        //5.将结果返回给用户
        return ResultAjax.succ(1);
    }

    @RequestMapping("/initUser")
    public ResultAjax initUser(HttpServletRequest request) {
        //判断是否登录
        Managerinfo managerinfo = SessionUtils.getManager(request);
        if (managerinfo==null) {
            return ResultAjax.fail(-2,"请先登录！");
        }
        List<Userinfo> list = userService.getUserAll();
        return ResultAjax.succ(list);
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

    @RequestMapping("/hireuser")
    public ResultAjax getHireUser(HttpServletRequest request) {
        //1.获取登录信息
        Managerinfo managerinfo = SessionUtils.getManager(request);
        if (managerinfo==null) {
            return ResultAjax.fail(-2,"请先登录！");
        }
        //2.组装HireUserVO
        //查询toyname username number date
        List<HireUserVO> hireUserVOList = allService.getHireUserVO();
        //4.返回数据
        return ResultAjax.succ(hireUserVOList);
    }

    // hiretoy.toyname  hiretoy.username hiretoy.number hiretoy.updatetime
    @RequestMapping("returnInit")
    public ResultAjax returnInit(HttpServletRequest request) {
        //1.验证是否登录
        Managerinfo managerinfo = SessionUtils.getManager(request);
        if (managerinfo==null) {
            return ResultAjax.fail(-2,"请先登录");
        }
        //2.获取数据
        List<HireUserVO> list = allService.getReturn();
        //3.返回数据
        return ResultAjax.succ(list);
    }
}