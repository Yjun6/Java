package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-18
 * Time:19:59
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public int add(Userinfo userinfo) {
        return userMapper.add(userinfo);
    }
}
