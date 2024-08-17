package com.example.demo.controller;

import com.example.demo.model.Result;
import com.example.demo.model.UserInfo;
import com.example.demo.service.UserService;
import com.example.demo.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Map;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //登录
    @RequestMapping("/login")
    public Result login(String userName, String password) {
        if( !StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
            return Result.fail("账户或密码为空");
        }
        // 校验
        UserInfo userInfo = userService.queryByName(userName);
        if (userInfo==null || userInfo.getId()<0) {
            return Result.fail("用户不存在");
        }
        if ( !password.equals(userInfo.getPassword()))  {
            return Result.fail("账号或密码错误");
        }
        //生成token
        Map<String, Object> claim = new Hashtable<>();
        claim.put("id", userInfo.getId());
        claim.put("name", userInfo.getUserName());
        String token = JwtUtils.getToken(claim);
        return Result.success(token);
    }

    /**获取登录用户的信息*/
    @RequestMapping("/getUserInfo")
    public UserInfo getUserInfo(HttpServletRequest request) {
        String token = request.getHeader("user_token");
        Integer id = JwtUtils.getUserIdFromToken(token);
        if (id == null) {
            return null;
        }
        return userService.queryById(id);
    }

    /**获取作者的信息*/
    @RequestMapping("/getAuthorInfo")
    public UserInfo getAuthorInfo(Integer blogId){
        if (blogId == null || blogId < 0) {
            return null;
        }
        return userService.getAuthorInfo(blogId);
    }

}
