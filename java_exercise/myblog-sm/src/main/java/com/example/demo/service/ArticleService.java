package com.example.demo.service;

import com.example.demo.dao.ArticleMapper;
import com.example.demo.model.Articleinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    public List<Articleinfo> getListByUid (Integer uid) {
        return articleMapper.getListByUid(uid);
    }

    public int del(Integer id, Integer uid) {
        return articleMapper.del(id, uid);
    }

    public int add(Articleinfo articleinfo) {
        return articleMapper.add(articleinfo);
    }

    public Articleinfo getArticleByIdAndUid(Integer id,Integer uid){
        return articleMapper.getArticleByIdAndUid(id, uid);
    }

    public int update(Articleinfo articleinfo){
        return articleMapper.update(articleinfo);
    }

    public Articleinfo getDetailById(Integer id) {
        return articleMapper.getDetailById(id);
    }

    public int getArtCountByUid(Integer uid) {
        return articleMapper.getArtCountByUid(uid);
    }

    public int incrementRCount(Integer id) {
        return articleMapper.incrementRCount(id);
    }

    public List<Articleinfo> getArtListByLimit(Integer limit, Integer offset) {
        return articleMapper.getArtListByLimit(limit,offset);
    }

    public Integer getCount() {
        return articleMapper.getCount();
    }
}
