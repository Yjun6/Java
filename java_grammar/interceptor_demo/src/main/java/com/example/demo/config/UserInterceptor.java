package com.example.demo.config;

import com.example.demo.common.AppVar;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 自定义拦截器
 */
@Component
public class UserInterceptor implements HandlerInterceptor {
    /*
    * 返回 true 表示拦截器拦截成功，继续执行后续方法
    * 返回false 表示拦截器拦截失败，不会执行后续的方法
    *  */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("do UserInterceptor");
        //业务内容
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute(AppVar.SESSION_KEY) != null) {
            return true;
        }
        return false;
    }
}
