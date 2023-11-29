package com.example.demo.dao;

import com.example.demo.model.Userinfo;
import com.example.demo.model.vo.UserinfoVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    @Insert("insert into user(username,password,nickname,gender,github) " +
            "values(#{username},#{password},#{nickname},#{gender},#{github})")
    int reg(Userinfo userinfo);

    @Select("select * from user where username=#{username}")
    Userinfo getUserByName(@Param("username") String username);

    @Select("select * from user where id = #{uid}")
    UserinfoVO getUserById(@Param("uid") Integer uid);

    @Update("update user set username=#{username},password=#{password}," +
            "nickname=#{nickname},gender=#{gender},github=#{github} where id=#{id}")
    int updateById(Userinfo userinfo);
}
