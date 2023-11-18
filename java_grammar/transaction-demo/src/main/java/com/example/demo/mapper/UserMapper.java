package com.example.demo.mapper;

import com.example.demo.model.Userinfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-18
 * Time:19:55
 */
@Mapper
public interface UserMapper {
    @Insert("insert into userinfo(username,password,age) values(#{username}, #{password},#{age})")
    int add(Userinfo userinfo);
}
