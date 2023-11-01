package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-01
 * Time:21:59
 */
@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/login")
    public Boolean login(String username, String password, HttpSession session) {
        //校验参数的合法性
//        if (username == null || password == null
//                || username.equals("") || password.equals("")) {
//            return false;
//        }

        if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)) {
            return false;
        }
        //用户名和密码的校验
        if ("zhangsan".equals(username) && "150".equals(password)) {
            //密码正确
            //设置session
            session.setAttribute("username", "zhangsan");
            return true;
        }
        return false;
    }

//    @RequestMapping("/getUserInfo")
//    public String getUserInfo(HttpSession session){
//        //从session获取登录用户
//        String username = (String)session.getAttribute("username");
//        return username;
//    }
    @RequestMapping("/getUserInfo")
    public String getUserInfo(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String username = null;
        if (session != null) {
            //从session获取登录用户
            username = (String) session.getAttribute("username");
        }
        return username;
    }
}
