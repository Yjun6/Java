package com.example.demo.controller;

import com.example.demo.common.ResultAjax;
import com.example.demo.common.SessionUtils;
import com.example.demo.model.Managerinfo;
import com.example.demo.model.Toyinfo;
import com.example.demo.model.Userinfo;
import com.example.demo.service.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/toy")
public class ToyController {
    @Autowired
    private ToyService toyService;

    @RequestMapping("/init")
    public ResultAjax getToyList(HttpServletRequest request) {
        //判断是否登录
        Managerinfo managerinfo = SessionUtils.getManager(request);
        if (managerinfo==null) {
            return ResultAjax.fail(-2,"请先登录！");
        }
        List<Toyinfo> list = toyService.getToyAll();
        return ResultAjax.succ(list);
    }

    @RequestMapping("/add")
    public ResultAjax addToy(Toyinfo toyinfo, HttpServletRequest request) {
        //1.判断是否登录
        Managerinfo managerinfo = SessionUtils.getManager(request);
        if (managerinfo==null) {
            return ResultAjax.fail(-2,"请先登录！");
        }
        //2.参数校验
        if (toyinfo==null || !StringUtils.hasLength(toyinfo.getName())
                || !StringUtils.hasLength(toyinfo.getSituation())) {
            return ResultAjax.fail(-1,"非法参数");
        }
        //3.保存到数据库中
        int ret = toyService.addToy(toyinfo);
        return ResultAjax.succ(ret);
    }

    /**删除玩具*/
    @RequestMapping("/del")
    public ResultAjax del(Integer id, HttpServletRequest request) {
        //1.参数校验
        if (id==null || id<=0) {
            return ResultAjax.fail(-1,"参数错误!");
        }
        //2.得到当前登录的用户
        Managerinfo managerinfo = SessionUtils.getManager(request);
        if (managerinfo == null) {
            return ResultAjax.fail(-1,"请先登录");
        }
        //3.删除操作
        int ret = toyService.del(id);
        //5.将结果返回给前端
        return ResultAjax.succ(ret);
    }

    @RequestMapping("/detail")
    public ResultAjax getToyById(Integer id, HttpServletRequest request) {
        //判断是否登录
        Managerinfo managerinfo = SessionUtils.getManager(request);
        if (managerinfo==null) {
            return ResultAjax.fail(-2,"请先登录！");
        }
        //验证id是否合法
        if (id==null || id <= 0) {
            return ResultAjax.fail(-1,"非法参数");
        }
        //根据Id查询玩具
        Toyinfo toyinfo = toyService.getToyById(id);
        return ResultAjax.succ(toyinfo);
    }

    @RequestMapping("/save")
    public ResultAjax updateToyById(Toyinfo toyinfo, HttpServletRequest request) {
        //1.判断是否登录
        Managerinfo managerinfo = SessionUtils.getManager(request);
        if (managerinfo==null) {
            return ResultAjax.fail(-2,"请先登录！");
        }
        //2.参数校验
        if (toyinfo==null || !StringUtils.hasLength(toyinfo.getName())
                || !StringUtils.hasLength(toyinfo.getSituation())) {
            return ResultAjax.fail(-1,"非法参数");
        }
        //3.校验id是否存在
        Integer ret = toyService.selectToyById(toyinfo.getId());
        if (ret==null || ret<=0) {
            return ResultAjax.fail(-1,"非法参数");
        }
        //4.根据Id修改信息
        ret = toyService.updateToyById(toyinfo);
        return ResultAjax.succ(ret);
    }
}
