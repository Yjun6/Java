package com.example.demo.service;

import com.example.demo.mapper.BlogInfoMapper;
import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.model.BlogInfo;
import com.example.demo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private BlogInfoMapper blogInfoMapper;

    public UserInfo queryByName(String userName) {
        return userInfoMapper.queryByName(userName);
    }

    public UserInfo queryById(Integer id) {
        return userInfoMapper.queryById(id);
    }

    public UserInfo getAuthorInfo(Integer blogId) {
        //先获取userid  再获取作者信息
        BlogInfo blogInfo = blogInfoMapper.queryById(blogId);
        if (blogInfo == null || blogInfo.getUserId() < 0) {
            return null;
        }
        return userInfoMapper.queryById(blogInfo.getUserId());
    }
}
