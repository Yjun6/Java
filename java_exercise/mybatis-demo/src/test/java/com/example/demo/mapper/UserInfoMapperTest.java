package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 單元測試代碼
 */
@Slf4j
@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void selectAll() {
        List<UserInfo> list = userInfoMapper.selectAll();
        log.info(list.toString());
    }

    @Test
    void selectOne() {
        log.info(userInfoMapper.selectOne(2).toString());
    }
}