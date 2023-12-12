package com.example.demo.dao;


import com.example.demo.model.Managerinfo;
import com.example.demo.model.Userinfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ManagerMapper {
    @Insert("insert into manager(username,password) values(#{username},#{password})")
    int reg(Managerinfo managerinfo);

    @Select("select * from manager where username=#{username}")
    Managerinfo getManagerByName(@Param("username") String username);
}
