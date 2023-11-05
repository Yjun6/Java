package com.example.demo.ioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-05
 * Time:11:13
 */

@Configuration
public class BeanConfig {
    @Bean
    public String name() {
        return "zhangsan";
//        return  new Scanner(System.in).nextLine();
    }

//    @Primary
    @Bean("u1")
    public UserInfo userInfo(String name) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfo.setAge(34);
        userInfo.setId(1);
        return userInfo;
    }

    @Bean("u2")
    public UserInfo userInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("李四");
        userInfo.setAge(34);
        userInfo.setId(1);
        return userInfo;
    }
}
