//package com.example.common;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User:Yu
// * Date:2023-11-26
// * Time:15:33
// */
//
//public class RedisConfig {
//
//    /**
//     * 如果key和value都使用的StringRedisSerializer序列化器，则推荐使用StringRedisTemplate
//     *
//     * 配置Redis的Key和Value的序列化器
//     * @param redisTemplate 从容器中获取RedisTemplate
//     * @return 修改后的RedisTemple
//     */
//    @Bean
//    public RedisTemplate<Object, Object> redisStringTemplate(RedisTemplate<Object, Object> redisTemplate) {
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(stringRedisSerializer);
//        // 如果手动将Value转换成了JSON，就不要再用JSON序列化器了。
//        // redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
//        redisTemplate.setValueSerializer(stringRedisSerializer);
//        return redisTemplate;
//    }
//
//}