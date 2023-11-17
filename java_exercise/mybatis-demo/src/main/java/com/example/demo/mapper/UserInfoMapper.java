package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
//    @Select("select * from userinfo")
    List<UserInfo> selectAll();

//    @Select("select * from userinfo where id = #{id}")
//    UserInfo selectOne(Integer id); //不具有通配性
    UserInfo selectOne(@Param("id") Integer uid);

    UserInfo login(@Param("username") String username,@Param("password") String password);

    List<UserInfo> getAllByOrder(@Param("myOrder") String myOrder);

    int deleteById(@Param("id") Integer id);

    int update(UserInfo userInfo);

    int add(UserInfo userInfo);

    //添加自增主键Id,返回id
    int insertId(UserInfo userInfo);

    List<UserInfo> getLikeList(@Param("username") String username);

    int add2(UserInfo userInfo);

    int add3(UserInfo userInfo);

    UserInfo getListByWhere(UserInfo userInfo);

    int update2(UserInfo userInfo);

    int delByIds(List<Integer> ids);

}
