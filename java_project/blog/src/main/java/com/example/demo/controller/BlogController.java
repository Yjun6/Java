package com.example.demo.controller;

import com.example.demo.model.BlogInfo;
import com.example.demo.model.Result;
import com.example.demo.service.BlogService;
import com.example.demo.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/blog")
@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    /**获取博客列表*/
    @RequestMapping("/getlist")
    public List<BlogInfo> getBlogList() {
        return blogService.getBlogList();
    }

    /**获取博客详情页*/
    @RequestMapping("/getBlogDetail")
    public BlogInfo getBlogDetail(Integer blogId, HttpServletRequest request){
        //判断用户是否为博客作者
        BlogInfo blogInfo = blogService.getBlogDetail(blogId);
        String token = request.getHeader("user_token");
        Integer userId = JwtUtils.getUserIdFromToken(token);
        blogInfo.setLoginUser(userId == blogInfo.getUserId());
        return blogInfo;
    }

    /**发布博客*/
    @RequestMapping("/add")
    public Result publishBlog(String title, String content, HttpServletRequest request){
        //从token获取userId
        //构造blog
        String token = request.getHeader("user_token");
        Integer userId = JwtUtils.getUserIdFromToken(token);
        if (userId==null || userId<0) {
            return Result.fail("用户未登录",false);
        }
        if (title == null || content == null) {
            return Result.fail("文章信息不完整",false);
        }
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setTitle(title);
        blogInfo.setContent(content);
        blogInfo.setUserId(userId);
        blogService.insertBlog(blogInfo);
        return Result.success(true);
    }

    /**编辑博客*/
    @RequestMapping("/update")
    public Result updateBlog(BlogInfo blogInfo, HttpServletRequest request){
        //判断用户是否为博客作者
        String token = request.getHeader("user_token");
        Integer userId = JwtUtils.getUserIdFromToken(token);
        //blogInfo 中的博客id 查找userId
        BlogInfo blogDetail = blogService.getBlogDetail(blogInfo.getId());
        if (userId != blogDetail.getUserId()){
            return Result.fail("没有该权限",false);
        }
        blogService.updateBlog(blogInfo);
        return Result.success(true);
    }

    /**删除博客*/
    @RequestMapping("/delete")
    public Result deleteBlog(Integer blogId, HttpServletRequest request) {
        //判断用户是否为博客作者
        String token = request.getHeader("user_token");
        Integer userId = JwtUtils.getUserIdFromToken(token);
        //blogInfo 中的博客id 查找userId
        BlogInfo blogDetail = blogService.getBlogDetail(blogId);
        if (userId != blogDetail.getUserId()){
            return Result.fail("没有该权限",false);
        }
        blogService.deleteBlog(blogId);
        return Result.success(true);
    }
}
