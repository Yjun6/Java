package com.example.demo.model.vo;

import com.example.demo.model.Userinfo;
import lombok.Data;

/**
 * userinfo的拓展
 */
@Data
public class UserinfoVO extends Userinfo {
    private String checkCode;//验证码
    private Integer artCount;//用户发布的总文章数
}
