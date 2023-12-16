package com.example.demo.dao;

import com.example.demo.model.vo.HireUserVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 多表查询
 * */

public interface AllMapper {

    @Select("select toy.name toyname,user.username username,count(toyid) number,hireuser.createtime date\n" +
            "    from hireuser\n" +
            "    join user on user.id=hireuser.userid\n" +
            "    join toy on toy.id=hireuser.toyid\n" +
            "    where hireuser.state=1 " +
            "    group by hireuser.createtime;")
    List<HireUserVO> getHireUserVO();

    @Select("select toy.name toyname,count(toyid) number,hireuser.createtime date,toy.id toyid\n" +
            "    from hireuser\n" +
            "    join user on user.id=hireuser.userid\n" +
            "    join toy on toy.id=hireuser.toyid\n" +
            "    where hireuser.state=#{state} and hireuser.userid=#{userid}" +
            "    group by hireuser.createtime;")
    List<HireUserVO> getHireUserVOById(@Param("userid") Integer userid,@Param("state") Integer state);

    @Select("select count(*)\n" +
            "        from hireuser\n" +
            "        join user on user.id=hireuser.userid\n" +
            "        join toy on toy.id=hireuser.toyid\n" +
            "        where hireuser.userid=#{userid} and hireuser.createtime=#{createtime} and hireuser.toyid=#{toyid};")
    int getHireUser(@Param("userid") Integer userid,@Param("toyid") Integer toyid,@Param("createtime") LocalDateTime createtime);
}

//
//    select toy.name toyname,count(toyid) number,hireuser.createtime date
//        from hireuser
//        join user on user.id=hireuser.userid
//        join toy on toy.id=hireuser.toyid
//        where hireuser.state=1 and hireuser.userid=6
//        group by hireuser.createtime;


//    String toyid,String date,String returntoy
//select count(*)
//        from hireuser
//        join user on user.id=hireuser.userid
//        join toy on toy.id=hireuser.toyid
//        where hireuser.userid=6 and hireuser.createtime='2023-12-15 14:12:15';