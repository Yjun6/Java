package com.example.demo.dao;

import com.example.demo.model.Userinfo;
import com.example.demo.model.vo.UserinfoVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Insert("insert into user(username,password) values(#{username},#{password})")
    int reg(Userinfo userinfo);
    @Select("select * from user where username=#{username}")
    Userinfo getUserByName(@Param("username") String username);
}
