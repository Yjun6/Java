package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Captchainfo implements Serializable{
    private String captcha;
}
