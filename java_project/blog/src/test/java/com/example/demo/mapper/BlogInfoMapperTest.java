package com.example.demo.mapper;

import com.example.demo.model.BlogInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2024-08-09
 * Time:12:59
 */
@SpringBootTest
class BlogInfoMapperTest {

    @Autowired
    private BlogInfoMapper blogInfoMapper;

    @Test
    void queryBlogList() {
        System.out.println(blogInfoMapper.queryBlogList());
    }

    @Test
    void queryById() {
        System.out.println(blogInfoMapper.queryById(1));
    }

    @Test
    void update() {
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setTitle("奥运会 最终得奖者");
        blogInfo.setContent("谁知道啊");
        blogInfo.setId(3);
        System.out.println(blogInfoMapper.update(blogInfo));
    }

    @Test
    void delete() {
        System.out.println(blogInfoMapper.delete(3));
    }

    @Test
    void insertBlog() {
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setTitle("苏系");
        blogInfo.setContent("今天中午吃饱饭了吗");
        blogInfo.setUserId(1);
        blogInfoMapper.insertBlog(blogInfo);
    }
}