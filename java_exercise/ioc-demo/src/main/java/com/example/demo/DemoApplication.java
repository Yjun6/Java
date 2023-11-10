package com.example.demo;

import com.example.demo.ioc.config.UserInfo;
import com.example.demo.ioc.controlller.UserController;
import com.example.demo.ioc.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


//配置扫描路径
@ComponentScan("com.example.demo")
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

//		//从context中获取bean
//		UserController bean = context.getBean(UserController.class);
//		bean.doUserController();
//		//获取service
//		UserService bean2 = context.getBean(UserService.class);
//		bean2.doUserService();
//
//		//通过名称获取
//		// 如果类名第一个字母和第二个字母都大写，那就这两个都小写
//		// 否则就第一个字母小写，其他照常大小写
		UserController bean3 = (UserController) context.getBean("userController");
		bean3.doUserController();
//		//
//		UserService bean4 = (UserService)context.getBean("userService");
//		bean4.doUserService();
//
//
//		//测试bean
//		UserInfo userInfo = (UserInfo) context.getBean("userInfo2");
//		System.out.println(userInfo);
//
//		UserInfo userInfo1 = context.getBean("userInfo1", UserInfo.class);
//		System.out.println(userInfo1);


	}

}






