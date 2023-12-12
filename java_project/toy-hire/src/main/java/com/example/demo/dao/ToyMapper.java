package com.example.demo.dao;

import com.example.demo.model.Toyinfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ToyMapper {
    @Select("select * from toy")
    List<Toyinfo> getToyAll();

    @Insert("insert into toy(name,situation,price,inventory) " +
            "values(#{name},#{situation},#{price},#{inventory})")
    int addToy(Toyinfo toyinfo);

    @Delete("delete from toy where id=#{id}")
    int del(@Param("id") Integer id);

    @Select("select name,situation,price,inventory from toy where id=#{id}")
    Toyinfo getToyById(@Param("id") Integer id);

    @Select("select id from toy where id=#{id}")
    Integer selectToyById(@Param("id") Integer id);

    @Update("update toy set name=#{name},situation=#{situation},price=#{price},inventory=#{inventory} where id=#{id}")
    int updateToyById(Toyinfo toyinfo);
}
