package com.example.demo.common;

import com.example.demo.model.Managerinfo;
import com.example.demo.model.Userinfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * session工具类
 */
public class SessionUtils {

    /**
     * 得到用户的session信息
     */
    public static Userinfo getUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute(AppVariable.SESSION_USERINFO_KEY)!=null) {
            //用户是登录状态
            return (Userinfo) session.getAttribute(AppVariable.SESSION_USERINFO_KEY);
        }
        return null;
    }

    /**
     * 得到管理员的session信息
     */
    public static Managerinfo getManager(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute(AppVariable.SESSION_USERINFO_KEY)!=null) {
            //用户是登录状态
            return (Managerinfo) session.getAttribute(AppVariable.SESSION_USERINFO_KEY);
        }
        return null;
    }
}
