package com.example.demo.dao;

import com.example.demo.model.Articleinfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ArticleMapper {
    @Select("select * from article where uid=#{uid} order by id desc")
    List<Articleinfo> getListByUid(@Param("uid")Integer uid);

    @Delete("delete from article where id=#{id} and uid=#{uid}")
    int del(@Param("id") Integer id, int uid);

    @Insert("insert into article(title,content,uid) values(#{title},#{content},#{uid})")
    int add(Articleinfo articleinfo);

    @Select("select * from article where id=#{id} and uid=#{uid}")
    Articleinfo getArticleByIdAndUid(@Param("id") Integer id, @Param("uid") Integer uid);

    @Update("update article set title=#{title},content=#{content} where id=#{id} and uid=#{uid}")
    int update(Articleinfo articleinfo);

    @Select("select * from article where id=#{id}")
    Articleinfo getDetailById(@Param("id") int id);

    @Select("select count(id) from article where uid=#{uid}")
    int getArtCountByUid(@Param("uid") Integer uid);

    @Update("update article set rcount=rcount+1 where id=#{id}")
    int incrementRCount(Integer id);
}
