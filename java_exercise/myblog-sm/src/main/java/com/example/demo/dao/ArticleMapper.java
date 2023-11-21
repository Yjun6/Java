package com.example.demo.dao;

import com.example.demo.model.Articleinfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleMapper {
    @Select("select * from article where uid=#{uid} order by id desc")
    List<Articleinfo> getListByUid(@Param("uid")Integer uid);

    @Delete("delete from article where id=#{id} and uid=#{uid}")
    int del(@Param("id") Integer id, int uid);
}
