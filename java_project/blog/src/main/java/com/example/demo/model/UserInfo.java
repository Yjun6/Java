package com.example.demo.model;

import lombok.Data;

import java.util.Date;

/**
 * 用户信息  和 数据库 java_blog_spring  匹配
 */
@Data
public class UserInfo {
    private Integer id;
    private String userName;
    private String password;
    private String githubUrl;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;

}
