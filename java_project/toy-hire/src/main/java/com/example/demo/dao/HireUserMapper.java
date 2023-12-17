package com.example.demo.dao;


import com.example.demo.model.HireUserinfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HireUserMapper {
    @Insert("insert into hireuser(userid,toyid,createtime,state) " +
            "values(#{userid},#{toyid},#{createtime},#{state})")
    public int insertHireUser(HireUserinfo hireUser);

   @Select("select * from hireuser where state=1")
    List<HireUserinfo> getHireUserAll();

    @Update("update hireuser set state=#{state},updatetime=#{updatetime}" +
            "where userid=#{userid} and toyid=#{toyid} and createtime=#{createtime} and state=1")
    int updateState(HireUserinfo hireUserinfo);
}
