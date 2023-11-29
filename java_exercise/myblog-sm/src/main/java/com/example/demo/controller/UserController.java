package com.example.demo.controller;

import com.example.demo.common.AppVariable;
import com.example.demo.common.PasswordUtils;
import com.example.demo.common.ResultAjax;
import com.example.demo.common.SessionUtils;
import com.example.demo.model.Userinfo;
import com.example.demo.model.vo.UserinfoVO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
        //先将密码进行加盐加密
        userinfo.setPassword(PasswordUtils.encrypt(userinfo.getPassword()));
        //2.请求service进行添加参数
        int result = userService.reg(userinfo);
        //3.执行结果返回给前端
        return ResultAjax.succ(result);
    }

    /**
     * 登录接口
     * */
    @RequestMapping("/login")
    public ResultAjax login(UserinfoVO userinfoVO, HttpServletRequest request) {
        //1.参数校验
        if (userinfoVO==null
            || !StringUtils.hasLength(userinfoVO.getUsername())
        || !StringUtils.hasLength(userinfoVO.getPassword())) {
            //非法登录
            return ResultAjax.fail(-1,"非法登录");
        }
        //2.根据用户名(唯一的)查询对象
        Userinfo userinfo = userService.getUserByName(userinfoVO.getUsername());
        if (userinfo==null || userinfo.getId()==0) {
            //此用户不存在
            return ResultAjax.fail(-2,"用户名或密码错误");
        }
        //3.使用对象中的密码和用户输入的密码进行比较
//        if (!userinfoVO.getPassword().equals(userinfo.getPassword())) {
        //加盐验证
        if (!PasswordUtils.decrypt(userinfoVO.getPassword(),userinfo.getPassword())){
            //密码错误
            return ResultAjax.fail(-1,"用户名或密码错误");
        }
        //4.设置session
        HttpSession session = request.getSession();
        session.setAttribute(AppVariable.SESSION_USERINFO_KEY,userinfo);
        //5.将结果返回给用户
        return ResultAjax.succ(1);
    }

    /**
     * 注销
     * */
    @RequestMapping("/logout")
    public ResultAjax logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session!=null && session.getAttribute(AppVariable.SESSION_USERINFO_KEY)!=null) {
            session.removeAttribute(AppVariable.SESSION_USERINFO_KEY);
        }
        return ResultAjax.succ(1);
    }

    /**
     * 返回用户信息
     * */
    @RequestMapping("/getuser")
    public ResultAjax getuser(Integer id) {
        //1.验证id
        if(id==null || id<=0) {
            return ResultAjax.fail(-1,"参数错误！");
        }
        //2.根据id查询用户信息
        UserinfoVO userinfoVO = userService.getUserById(id);
        //3.返回信息
        return ResultAjax.succ(userinfoVO);
    }

    /**
     * 用户确定修改信息
     *  username
     *  password
     *  nickname
     *  gender
     *  github
     * */
    @RequestMapping("/mod")
    public ResultAjax mod(Userinfo userinfo,String oldpassword,HttpServletRequest request) {
        /**
         *         articleinfo.setUid(userinfo.getId());
         *         return ResultAjax.succ(articleService.update(articleinfo));
         */
        //1.参数校验
        if (userinfo==null || !StringUtils.hasLength(userinfo.getUsername()) || !StringUtils.hasLength(userinfo.getPassword())
        || !StringUtils.hasLength(userinfo.getNickname()) || !StringUtils.hasLength(userinfo.getGender())
        || !StringUtils.hasLength(userinfo.getGithub())) {
            return ResultAjax.fail(-1,"非法参数");
        }
        //2.获取登录用户
        Userinfo olduserinfo = SessionUtils.getUser(request);
        if (olduserinfo == null) {
            return ResultAjax.fail(-2,"请先登录");
        }
        //3.校验该信息是否属于这个用户
        //校验密码是否匹配
        if(PasswordUtils.decrypt(oldpassword,olduserinfo.getPassword()) == false) {
            return ResultAjax.fail(-1,"密码错误，请重新输入");
        }
        //4.执行修改操作
        userinfo.setId(olduserinfo.getId());
        //密码加盐
        userinfo.setPassword(PasswordUtils.encrypt(userinfo.getPassword()));
        //5.将结果返回给前端
        return ResultAjax.succ(userService.updateById(userinfo));
    }

    @RequestMapping("/test")
    public int test() {
        return 3;
    }
}
