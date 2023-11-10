package com.example.demo.ioc.controlller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * 打印日志 工厂模式
 */
@RestController
public class LoggerController {
    private static Logger logger = LoggerFactory.getLogger(LoggerController.class);

    @PostConstruct
    public void print() {
        System.out.println("打印日志");
        logger.info("============日志框架打印==========");
    }

}
