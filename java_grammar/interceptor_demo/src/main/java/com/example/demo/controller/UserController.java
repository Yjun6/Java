package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getuser")
    public String getUser() {
        System.out.println("do getUser");
        return "user";
    }

    @RequestMapping("/reg")
    public String reg() {
        System.out.println("do reg");
        return "reg";
    }

    @RequestMapping("/login")
    public String login() {
        System.out.println("do login");
        return "login";
    }

}
