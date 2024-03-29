package com.example.demo.service;

import com.example.demo.dao.ToyMapper;
import com.example.demo.model.Toyinfo;
import com.example.demo.model.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToyService {
    @Autowired
    ToyMapper toyMapper;

    public List<Toyinfo> getToyAll(){
        return toyMapper.getToyAll();
    }

    public int addToy(Toyinfo toyinfo) {
        return toyMapper.addToy(toyinfo);
    }

    public int del(Integer id) {
        return toyMapper.del(id);
    }

    public Toyinfo getToyById(Integer id) {
        return toyMapper.getToyById(id);
    }

    public Integer selectToyById(Integer id) {
        return toyMapper.selectToyById(id);
    }

    public Integer updateToyById(Toyinfo toyinfo) {
        return toyMapper.updateToyById(toyinfo);
    }

    public List<Toyinfo> getToyListByInventory() {
        return toyMapper.getToyListByInventory();
    }

    public Toyinfo selectToyByIdAll(Integer id) {
        return toyMapper.selectToyByIdAll(id);
    }

    public Toyinfo selectToyByName(String name) {
        return toyMapper.selectToyByName(name);
    }

    public Integer updateToyInventory(Integer id,Integer inventory) {
        return toyMapper.updateToyInventory(id,inventory);
    }

    public int addToyById(Toyinfo toyinfo){
        return toyMapper.addToyById(toyinfo);
    }
}
