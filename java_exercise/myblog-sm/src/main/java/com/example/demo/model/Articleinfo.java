package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-19
 * Time:15:28
 */
@Data
public class Articleinfo implements Serializable {
    private int id;
    private String title;
    private String content;
    private Date createtime;
    @JsonFormat(pattern = "yyy-MM-dd HH:mm",timezone = "GMT+8")
    private LocalDateTime updatetime;
    private int uid;
    private int rcount;
    private int state;
}
