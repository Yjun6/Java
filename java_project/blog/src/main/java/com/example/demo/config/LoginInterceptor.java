package com.example.demo.config;

import com.example.demo.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录 拦截器
 */
@Slf4j
@Configuration
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("user_token");
        log.info("从header里获取token,token:"+token);
        Claims claims = JwtUtils.parseToken(token);
        if (claims == null) {
            //token 错误
            response.setStatus(401);
            return false;
        }
        return true;
    }
}
