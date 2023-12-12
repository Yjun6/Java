package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Toyinfo implements Serializable {
    private Integer id;
    private String name;
    private String situation;
    private Integer price;
    private Integer inventory;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private int state;
}
