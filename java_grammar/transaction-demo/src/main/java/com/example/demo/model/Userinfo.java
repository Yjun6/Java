package com.example.demo.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-18
 * Time:19:51
 */
@Data
public class Userinfo {
    private Integer id;
    private String username;
    private String password;
    private int age;
    private Integer gender;
    private String phone;
    private Integer deleteFlag;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
