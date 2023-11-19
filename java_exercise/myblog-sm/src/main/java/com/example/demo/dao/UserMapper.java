package com.example.demo.dao;

import com.example.demo.model.Userinfo;
import org.apache.ibatis.annotations.Insert;

public interface UserMapper {
    @Insert("insert into user(username,password) values(#{username},#{password})")
    int reg(Userinfo userinfo);
}
