package com.example.demo.controller;

import com.example.demo.common.ResultAjax;
import com.example.demo.model.Userinfo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册功能
     * */
    @RequestMapping("/reg")
    public ResultAjax reg(Userinfo userinfo) {
        //1.校验参数
        if (userinfo == null
            || !StringUtils.hasLength(userinfo.getUsername())
            || !StringUtils.hasLength(userinfo.getPassword())) {
            return ResultAjax.fail(-1,"非法参数");
        }
        //2.请求service进行添加参数
        int result = userService.reg(userinfo);
        //3.执行结果返回给前端
        return ResultAjax.succ(result);
    }

    /**
     * 登录接口
     * */
    @RequestMapping("/login")
    public ResultAjax login(Userinfo userinfo) {
        //1.参数校验
        //2.根据用户名(唯一的)查询对象
        return null;
    }

    @RequestMapping("/test")
    public int test() {
        return 3;
    }
}
