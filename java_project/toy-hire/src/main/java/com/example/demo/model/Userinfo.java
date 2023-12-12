package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Userinfo implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    private Integer cash;
    private Integer points;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private int state;
}
