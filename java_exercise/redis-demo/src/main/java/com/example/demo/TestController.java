package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

@RestController
public class TestController {

    private final String _REDIS_KEY = "_REDIS_KEY_";

    //Spring Boot自动处理
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @RequestMapping("/setval")
    public void setVal(String val) {
        redisTemplate.opsForValue()
                .set(_REDIS_KEY,val,1000, TimeUnit.SECONDS);
    }

    @RequestMapping("/getval")
    public String getValue() {
        return (String) redisTemplate.opsForValue().get(_REDIS_KEY);
    }
}



