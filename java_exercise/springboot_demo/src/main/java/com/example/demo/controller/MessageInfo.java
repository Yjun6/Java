package com.example.demo.controller;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-03
 * Time:11:15
 */

@Data
public class MessageInfo {
    private String from;
    private String to;
    private String say;
    private Date CreateTime;
}
