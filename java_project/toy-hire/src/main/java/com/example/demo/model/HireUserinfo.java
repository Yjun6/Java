package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class HireUserinfo implements Serializable {
    private Integer userid;
    private Integer toyid;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private int state; // 1 租借  0 归还
}
