package com.example.demo.common;

import com.example.demo.config.LoginIntercept;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 系统配置文件
 */
//@Configuration
//public class MyConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginIntercept())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/editor.md/**")
//                .excludePathPatterns("/img/*")
//                .excludePathPatterns("/js/*")
//                .excludePathPatterns("/css/*")
//                .excludePathPatterns("/login.html")
//                .excludePathPatterns("/user/login")
//                .excludePathPatterns("/reg.html")
//                .excludePathPatterns("/user/reg")
//                .excludePathPatterns("/blog_list.html")
//                .excludePathPatterns("/art/getlistbypage")
//                .excludePathPatterns("/art/increment_rcount")
//                .excludePathPatterns("/blog_content.html")
//                .excludePathPatterns("/art/detail");
//    }
//}
