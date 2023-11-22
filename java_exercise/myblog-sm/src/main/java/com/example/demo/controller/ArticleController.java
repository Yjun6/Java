package com.example.demo.controller;

import com.example.demo.common.ResultAjax;
import com.example.demo.common.SessionUtils;
import com.example.demo.model.Articleinfo;
import com.example.demo.model.Userinfo;
import com.example.demo.model.vo.UserinfoVO;
import com.example.demo.service.ArticleService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@RestController
@RequestMapping("/art")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    private UserService userService;

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


    /**添加文章*/
    @RequestMapping("/add")
    public ResultAjax add(Articleinfo articleinfo, HttpServletRequest request) {
        //1.参数校验
        if (articleinfo==null || !StringUtils.hasLength(articleinfo.getTitle())
        || !StringUtils.hasLength(articleinfo.getContent())) {
            return ResultAjax.fail(-1,"非法参数");
        }
        //2.组装数据
        Userinfo userinfo = SessionUtils.getUser(request);
        if (userinfo==null) {
            return ResultAjax.fail(-2,"请先登录！");
        }
        articleinfo.setUid(userinfo.getId());
        //3.添加数据进去数据库
        int ret = articleService.add(articleinfo);
        //4.将结果返回给前端
        return ResultAjax.succ(ret);
    }

    /**查询自己发表的文章*/
    @RequestMapping("/update_init")
    public ResultAjax updateInit(Integer id,HttpServletRequest request) {
        //1.参数校验
        if (id==null || id<=0) {
            return ResultAjax.fail(-1,"参数错误");
        }
        //2.得到当前登录用户的id
        Userinfo userinfo = SessionUtils.getUser(request);
        if (userinfo==null) {
            return ResultAjax.fail(-2,"请先登录");
        }
        //3.查询文章并校验权限 where id = id and uid = uid
        Articleinfo articleinfo = articleService.getArticleByIdAndUid(id, userinfo.getId());
        //4.见结果返回给前端
        return ResultAjax.succ(articleinfo);
    }

    /**修改文章信息*/
    @RequestMapping("/update")
    public ResultAjax update(Articleinfo articleinfo, HttpServletRequest request) {
        //1.参数校验
        if (articleinfo==null || !StringUtils.hasLength(articleinfo.getContent())
        || !StringUtils.hasLength(articleinfo.getTitle())
        || articleinfo.getId()==0) {
            return ResultAjax.fail(-1,"非法参数");
        }
        //2.获取登录用户
        Userinfo userinfo = SessionUtils.getUser(request);
        if (userinfo == null) {
            return ResultAjax.fail(-2,"请先登录");
        }
        //3.执行修改操作，并判断归属人 //4.将结果返回给前端
        articleinfo.setUid(userinfo.getId());
        return ResultAjax.succ(articleService.update(articleinfo));
    }

    /**查询文章详情页*/
    @RequestMapping("/detail")
    public ResultAjax detail(Integer id, HttpServletRequest request) throws ExecutionException, InterruptedException {
        //1.参数校验
        if (id==null || id<=0) {
            return ResultAjax.fail(-1,"非法参数");
        }
        //2.查询文章详情
        Articleinfo articleinfo = articleService.getDetailById(id);
        if (articleinfo==null) {
            return ResultAjax.fail(-1,"非法参数");
        }
        //3.根据uid查询文章作者详情
        FutureTask<UserinfoVO> userTask = new FutureTask(()->{
            return userService.getUserById(articleinfo.getUid());
        });
        taskExecutor.submit(userTask);
        //4.根据uid查询作者发布的总文章数
        FutureTask<Integer> artCountTask = new FutureTask<>(()->{
            return articleService.getArtCountByUid(articleinfo.getUid());
        });
        taskExecutor.submit(artCountTask);
        //5.组装数据
        //等待线程池任务执行完成
        UserinfoVO userinfoVO =  userTask.get();
        int artCount = artCountTask.get();
        userinfoVO.setArtCount(artCount);
        //6.返回结果给前端
        HashMap<String, Object> result = new HashMap<>();
        result.put("user", userinfoVO);
        result.put("art",articleinfo);
        return ResultAjax.succ(result);
    }

    @RequestMapping("/increment_rcount")
    public ResultAjax incrementRCount(Integer id) {
        //1.校验参数
        if (id==null || id<=0) {
            return ResultAjax.fail(-1,"非法参数");
        }
        //2.更改数据库  3.返回结果
        return ResultAjax.succ(articleService.incrementRCount(id));
    }
}
