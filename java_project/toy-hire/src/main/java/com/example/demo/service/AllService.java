package com.example.demo.service;

import com.example.demo.dao.AllMapper;
import com.example.demo.model.vo.HireUserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 多表查询的service
 */
@Service
public class AllService {

    @Autowired
    private AllMapper allMapper;

    public List<HireUserVO> getHireUserVO(){
        return allMapper.getHireUserVO();
    }

    public List<HireUserVO> getHireUserVOById(Integer userid, Integer state){
        return allMapper.getHireUserVOById(userid,state);
    }

    public int getHireUser(Integer userid,Integer toyid,LocalDateTime createtime){
        return allMapper.getHireUser(userid,toyid,createtime);
    }

    public List<HireUserVO> getReturnAllById(Integer id){
        return allMapper.getReturnAllById(id);
    }

    public     List<HireUserVO> getReturn(){
        return allMapper.getReturn();
    }
}
