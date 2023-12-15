package com.example.demo.model.vo;

import com.example.demo.model.HireUserinfo;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HireUserVO extends HireUserinfo {
    private String toyname;
    private String username;
    private Integer number;
    private LocalDateTime date;
    private Integer latedate;
}
