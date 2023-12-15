package com.example.demo.service;

import com.example.demo.dao.UserMapper;
import com.example.demo.model.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-12-11
 * Time:20:40
 */
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

    public List<Userinfo> getUserAll() {
        return userMapper.getUserAll();
    }
    public int getUserById (Integer id) {
        return userMapper.getUserById(id);
    }

    public int updateUserById(Userinfo userinfo) {
        return userMapper.updateUserById(userinfo);
    }

    public int updateUserByIdCash(Integer id,Integer cash) {
        return userMapper.updateUserByIdCash(id,cash);
    }

    public int updateUserByIdPoints(Integer id, Integer points) {
        return userMapper.updateUserByIdPoints(id,points);
    }
}
