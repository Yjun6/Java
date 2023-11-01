package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-01
 * Time:17:45
 */
@RequestMapping("/return")
//@RestController
@Controller //返回的是页面,视图
public class ReturnController {

    @RequestMapping("/index")
    public String returnIndex() {
        return "/index.html";
    }

    @ResponseBody
    @RequestMapping("/data")
    public String returnData() {
        return "返回视图需要的数据";
    }

    @ResponseBody
    @RequestMapping("/html")
    public String returnHtml() {
        return "<h1>返回html页面</h1>";
    }

    @ResponseBody
    @RequestMapping("/json")
    public Person returnJson() {
        Person person = new Person();
        person.setName("张三");
        person.setAge(23);
        person.setId(1);
        person.setSex("男");
        return person;
    }

    @ResponseBody
    @RequestMapping("/setStatus")
    public String setStatus(HttpServletResponse response) {
        response.setStatus(401);//通常表示没有登录
        return "设置状态码";//页面展示照常
    }

}
