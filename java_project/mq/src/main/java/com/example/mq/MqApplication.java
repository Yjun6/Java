package com.example.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MqApplication {
	//为了管理不被 spring 管理的属性和方法
	public static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(MqApplication.class, args);
	}

}
