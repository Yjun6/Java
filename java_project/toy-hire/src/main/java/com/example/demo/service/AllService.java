package com.example.demo.service;

import com.example.demo.dao.AllMapper;
import com.example.demo.model.vo.HireUserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
