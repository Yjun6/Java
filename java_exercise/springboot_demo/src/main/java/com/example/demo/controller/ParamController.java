package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-10-28
 * Time:18:05
 */
@RequestMapping("/param")
@RestController
public class ParamController {
    @RequestMapping("/m1")
    public String m1(String name) {
        return "接收到参数name:"+name;
    }

    @RequestMapping("/m2")
    public String m2(String name, Integer age) {
        return "接受到的参数name: "+ name + " ,age: " + age;
    }

    /*修改参数名字   必传参数*/
    @RequestMapping("/m3")
    public String m3(@RequestParam("name") String username) {
        return "username: " + username;
    }

    /*修改参数名字  非必传*/
    @RequestMapping("/m4")
    public String m4(@RequestParam(value = "name", required = false) String username) {
        return "username: " + username;
    }
}
