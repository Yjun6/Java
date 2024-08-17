package com.example.demo.service;

import com.example.demo.mapper.BlogInfoMapper;
import com.example.demo.model.BlogInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogInfoMapper blogInfoMapper;

    public List<BlogInfo> getBlogList() {
        return blogInfoMapper.queryBlogList();
    }

    public BlogInfo getBlogDetail(Integer blogId) {
        return blogInfoMapper.queryById(blogId);
    }

    public Integer insertBlog(BlogInfo blogInfo) {
        return blogInfoMapper.insertBlog(blogInfo);
    }

    public Integer updateBlog(BlogInfo blogInfo) {
        return blogInfoMapper.update(blogInfo);
    }

    public Integer deleteBlog(Integer blogId) {
        return blogInfoMapper.delete(blogId);
    }
}
