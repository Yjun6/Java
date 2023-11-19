package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 统一设计，此包下面的所有类都加上Mapper注解
@MapperScan("com.example.demo.dao")
public class MyblogDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyblogDemoApplication.class, args);
	}

}
