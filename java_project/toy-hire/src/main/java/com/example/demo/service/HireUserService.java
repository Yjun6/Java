package com.example.demo.service;

import com.example.demo.dao.HireUserMapper;
import com.example.demo.model.HireUserinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HireUserService {
    @Autowired
    private HireUserMapper hireUserMapper;

    public int insertHireUser(HireUserinfo hireUser) {
        return hireUserMapper.insertHireUser(hireUser);
    }

    public List<HireUserinfo> getHireUserAll(){
        return hireUserMapper.getHireUserAll();
    }
}
