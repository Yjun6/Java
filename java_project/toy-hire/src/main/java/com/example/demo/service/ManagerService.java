package com.example.demo.service;

import com.example.demo.dao.ManagerMapper;
import com.example.demo.model.Managerinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    @Autowired
    private ManagerMapper managerMapper;

    public int reg(Managerinfo managerinfo) {
        return managerMapper.reg(managerinfo);
    }

    public Managerinfo getManagerByName (String username) {
        return managerMapper.getManagerByName(username);
    }
}
