package com.example.demo.controller;

import com.example.demo.model.DBtypes;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-10
 * Time:14:56
 */
@RestController
public class DemoController {
    @Value("${demo.helo}")
    private String demo;

    @Value("${demo.key1}")
    private String key1;

    @Value("${demo.key2}")
    private String key2;

    @Autowired
    public Student student;

    @Autowired
    public DBtypes dBtypes;

    @PostConstruct
    public void init() {
        System.out.println(key1+" , " + key2);
        System.out.println("student: "+student);
        System.out.println("DBtypes:" + dBtypes);
    }

    @RequestMapping("/demo")
    public String readDemo() {
        return "demo.helo内容为： " + demo;
    }

}

