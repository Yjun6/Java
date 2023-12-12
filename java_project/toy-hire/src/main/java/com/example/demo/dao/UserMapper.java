package com.example.demo.dao;

import com.example.demo.model.Userinfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Insert("insert into user(username,password,email,phone,address) " +
            "values(#{username},#{password},#{email},#{phone},#{address})")
    int reg(Userinfo userinfo);

    @Select("select * from user where username=#{username}")
    Userinfo getUserByName(@Param("username") String username);

    @Select("select * from user ")
    List<Userinfo> getUserAll();
}
