package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * 拦截器
 */
@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private static final List<String> excludepath = Arrays.asList(
        "/user/login",
        "/**.html",
        "/pic/**",
        "/js/**",
        "/css/**",
        "/blog-editormd/**"
    );

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
                .excludePathPatterns(excludepath);
    }
}
