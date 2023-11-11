package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-11
 * Time:20:20
 */

@Mapper
public interface UserInfoMapper {
    @Select("select * from userinfo")
    List<UserInfo> selectAll();

}
