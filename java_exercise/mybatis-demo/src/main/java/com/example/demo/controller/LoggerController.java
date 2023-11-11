package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-11
 * Time:21:56
 */
@Slf4j
@RestController
public class LoggerController {
    @PostConstruct
    public void log() {
        log.info("==========info日誌========");
    }
}
