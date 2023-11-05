package com.example.demo.ioc.service;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-04
 * Time:15:46
 */

@Service
public class UserService {
    public void doUserService() {
        System.out.println("UserService run....");
    }
}
