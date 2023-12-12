package com.example.demo.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HireUser {
    private Integer userid;
    private Integer toyid;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private int state;
}
