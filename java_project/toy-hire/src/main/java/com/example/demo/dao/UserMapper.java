package com.example.demo.dao;

import com.example.demo.model.Toyinfo;
import com.example.demo.model.Userinfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    @Insert("insert into user(username,password,email,phone,address) " +
            "values(#{username},#{password},#{email},#{phone},#{address})")
    int reg(Userinfo userinfo);

    @Select("select * from user where username=#{username}")
    Userinfo getUserByName(@Param("username") String username);

    @Select("select * from user ")
    List<Userinfo> getUserAll();

    @Select("select id from user where id=#{id}")
    int getUserById(@Param("id") Integer id);

    @Update("update user set username=#{username},email=#{email},phone=#{phone},address=#{address} where id=#{id}")
    int updateUserById(Userinfo userinfo);

    @Update("update user set cash=#{cash} where id=#{id}")
    int updateUserByIdCash(@Param("id") Integer id,@Param("cash") Integer cash);

    @Update("update user set points=#{points} where id=#{id}")
    int updateUserByIdPoints(@Param("id") Integer id,@Param("points") Integer points);
}
