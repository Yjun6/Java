package com.example.demo.dao;


import com.example.demo.model.HireUserinfo;
import org.apache.ibatis.annotations.Insert;

public interface HireUserMapper {
//    private Integer userid;
//    private Integer toyid;
//    private LocalDateTime createtime;
//    private LocalDateTime updatetime;
//    private int state;
    @Insert("insert into hireuser(userid,toyid,createtime,state) " +
            "values(#{userid},#{toyid},#{createtime},#{state})")
    public int insertHireUser(HireUserinfo hireUser);
}
