package com.example.demo.ioc.controlller;

import com.example.demo.ioc.config.UserInfo;
import com.example.demo.ioc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-04
 * Time:13:50
 */

@Controller
public class UserController {
    @Autowired
    private UserService us;

//    @Qualifier("userInfo1")
//    @Autowired
//    private UserInfo userInfo;

//    @Autowired
//    public UserController(UserService us) {
//        this.us = us;
//    }

    @Resource(name = "u1")
    private UserInfo userInfo;


    public void doUserController() {
        us.doUserService();
        System.out.println(userInfo);
        System.out.println("userController run....");
    }
}
