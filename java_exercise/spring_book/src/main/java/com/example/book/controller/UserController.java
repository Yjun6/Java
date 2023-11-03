package com.example.book.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-03
 * Time:18:31
 */

@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/login")
    public Boolean login(String userName, String password, HttpSession session) {
        //校验参数
        if (!StringUtils.hasLength(userName)
                || !StringUtils.hasLength(password)) {
            return false;
        }
        //验证账号密码是否正确
        if ("zhangsan".equals(userName) && "150".equals(password)) {
            //验证成功
            //存session
            session.setAttribute("userName", userName);
            return true;
        }
        return false;
    }
}
