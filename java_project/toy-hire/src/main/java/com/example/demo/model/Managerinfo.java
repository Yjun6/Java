package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Managerinfo implements Serializable {
    private int id;
    private String username;
    private String password;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private int state;
}