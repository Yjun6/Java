package com.example.demo.controller;

import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-11
 * Time:20:33
 */

@RestController
public class UserInfoController {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @RequestMapping("/selectAll")
    public List<UserInfo> selectAll() {
        return userInfoMapper.selectAll();
    }
}
