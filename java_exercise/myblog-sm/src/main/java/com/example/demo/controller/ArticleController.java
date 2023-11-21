package com.example.demo.controller;

import com.example.demo.common.ResultAjax;
import com.example.demo.common.SessionUtils;
import com.example.demo.model.Articleinfo;
import com.example.demo.model.Userinfo;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/art")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    private static final int _DESC_LENGTH = 120;//文章摘要长度

    @RequestMapping("/mylist")
    public ResultAjax myList(HttpServletRequest request) {
        //1.得到当前登录用户
        Userinfo userinfo = SessionUtils.getUser(request);
        if (userinfo==null) {
            return ResultAjax.fail(-1,"请先登录");
        }
        //2.根据用户id查询此用户所有文章
        List<Articleinfo> list = articleService.getListByUid(userinfo.getId());
        //处理文章的摘要
         if (list!=null && list.size()>0) {
             //并发处理
             list.stream().parallel().forEach(articleinfo -> {
                 if (articleinfo.getContent().length() > 120) {
                    articleinfo.setContent(articleinfo.getContent().substring(0,_DESC_LENGTH));
                 }
             });
         }
        //3.返回给前端
        return ResultAjax.succ(list);
    }

    /**删除文章*/
    @RequestMapping("/del")
    public ResultAjax del(Integer id, HttpServletRequest request) {
        //1.参数校验
        if (id==null || id<=0) {
            return ResultAjax.fail(-1,"参数错误!");
        }
        //2.得到当前登录的用户
        Userinfo userinfo = SessionUtils.getUser(request);
        if (userinfo == null) {
            return ResultAjax.fail(-1,"请先登录");
        }
        //3.判断文章归属人  4.删除操作
        int ret = articleService.del(id, userinfo.getId());
        //5.将结果返回给前端
        return ResultAjax.succ(ret);
    }
}
