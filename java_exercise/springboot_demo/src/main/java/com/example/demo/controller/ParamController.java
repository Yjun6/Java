package com.example.demo.controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

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

    //获取url中的内容
    @RequestMapping("/m5/{userId}/{name}")
    public String m5(@PathVariable Integer userId, @PathVariable String name) {
        return "userId: " + userId + "name: " + name;
    }

    /*上传文件*/
    @RequestMapping("/m6")
    public String m6(@RequestPart MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        file.transferTo(new File("D:/tmp/" + file.getOriginalFilename()));
        return "success";
    }


    /*获取cookie*/
    @RequestMapping("/getCookie")
    public String getCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie : cookies) {
//            System.out.println(cookie.getName() + " : " + cookie.getValue());
//        }
        //cookie可能不存在，空指针异常
        if (cookies != null) {
            Arrays.stream(cookies).forEach(cookie -> {
                System.out.println(cookie.getName() + " : " + cookie.getValue());
            });
        }
        return "获取cookie成功";
    }

    /*获取指定cookie*/
    @RequestMapping("/getCookie2")
    public String getCookie2(@CookieValue String bite) {
        return "bite中存储的值： " + bite;
    }


    //放一个session进去
    @RequestMapping("/setSession")
    public String setSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("username", "张三");
        return "success";
    }
    /*获取session*/
    @RequestMapping("/getSession")
    public String getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String username = (String)session.getAttribute("username");
            return "登录用户： " + username;
        }
        return "session为空";
    }

    //通过指定名字拿到指定session 必传选项
    @RequestMapping("/getSession2")
    public String getSession2(@SessionAttribute(required = false) String username) {
        return "username : " + username;
    }

    @RequestMapping("/getSession3")
    public String getSession3(HttpSession session) {
        String username = (String)session.getAttribute("username");
        return "登录用户： " + username;
    }

    /*获取header*/
    @RequestMapping("/getHeader")
    public String getHeader (HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        return "userAgent : " + userAgent;
    }

    /*获取header*/
    @RequestMapping("/getHeader2")
    public String getHeader2 (@RequestHeader("User-Agent") String userAgent) {
        return "userAgent : " + userAgent;
    }
}
