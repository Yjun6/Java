package com.example.demo.controller;

import com.example.demo.common.AppVariable;
import com.example.demo.common.PasswordUtils;
import com.example.demo.common.ResultAjax;
import com.example.demo.model.Userinfo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


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

}
