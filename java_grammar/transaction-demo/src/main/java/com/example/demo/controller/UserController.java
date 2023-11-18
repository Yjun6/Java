package com.example.demo.controller;

import com.example.demo.model.Userinfo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-18
 * Time:20:02
 */
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    @Transactional
    public int add() {
        //1.非空判断
        Userinfo userinfo = new Userinfo();
        userinfo.setUsername("阿发");
        userinfo.setPassword("gegefdw");
        userinfo.setAge(29);
        //2.调用service执行添加
        int result = userService.add(userinfo);
        System.out.println("result: " + result);
        int num = 10/0;
        //3.返回结果
        return 0;
    }
}
