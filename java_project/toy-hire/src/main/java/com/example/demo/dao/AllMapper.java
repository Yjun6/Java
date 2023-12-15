package com.example.demo.dao;

import com.example.demo.model.vo.HireUserVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    @Select("select toy.name toyname,count(toyid) number,hireuser.createtime date\n" +
            "    from hireuser\n" +
            "    join user on user.id=hireuser.userid\n" +
            "    join toy on toy.id=hireuser.toyid\n" +
            "    where hireuser.state=#{state} and hireuser.userid=#{userid}" +
            "    group by hireuser.createtime;")
    List<HireUserVO> getHireUserVOById(@Param("userid") Integer userid,@Param("state") Integer state);
}

//
//    select toy.name toyname,count(toyid) number,hireuser.createtime date
//        from hireuser
//        join user on user.id=hireuser.userid
//        join toy on toy.id=hireuser.toyid
//        where hireuser.state=1 and hireuser.userid=6
//        group by hireuser.createtime;
