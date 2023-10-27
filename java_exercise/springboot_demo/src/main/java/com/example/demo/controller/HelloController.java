package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-10-27
 * Time:19:43
 */
@RestController
public class HelloController {
    @RequestMapping("/sayhi")
     public String sayHi() {
         return "hello,SpringBoot";
     }
}
