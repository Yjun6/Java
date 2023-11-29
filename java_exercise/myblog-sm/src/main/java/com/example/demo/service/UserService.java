package com.example.demo.service;

import com.example.demo.dao.UserMapper;
import com.example.demo.model.Userinfo;
import com.example.demo.model.vo.UserinfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public int reg(Userinfo userinfo) {
        return userMapper.reg(userinfo);
    }

    public Userinfo getUserByName (String username) {
        return userMapper.getUserByName(username);
    }

    public UserinfoVO getUserById(Integer uid) {
        return userMapper.getUserById(uid);
    }

    public int updateById(Userinfo userinfo) {
        return userMapper.updateById(userinfo);
    }
}
