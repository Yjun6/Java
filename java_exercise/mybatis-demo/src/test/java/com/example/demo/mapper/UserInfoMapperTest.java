package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        System.out.println(list.toString());
    }

    @Test
    void selectOne() {
        log.info(userInfoMapper.selectOne(2).toString());
    }

    @Test
    void login() {
        System.out.println(userInfoMapper.login("admin", "admin"));
    }

    @Test
    void getAllByOrder() {
        System.out.println(userInfoMapper.getAllByOrder("desc"));
    }

    @Transactional //使用这个注解，不会真正影响数据库
    @Test
    void deleteById() {
        System.out.println(userInfoMapper.deleteById(2));
        selectAll();
    }

    @Transactional
    @Test
    void update() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(2);
        userInfo.setUsername("成都");
        System.out.println(userInfoMapper.update(userInfo));
        selectAll();
    }

    @Test
    void add() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("何佬");
        userInfo.setPassword("168453120");
        userInfo.setPhone("8946513");
        userInfo.setAge(25);
        userInfoMapper.add(userInfo);
        selectAll();
    }

    @Test
    void insertId() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("语佬");
        userInfo.setPassword("14865");
        userInfo.setPhone("6513sg");
        userInfo.setAge(35);
        userInfoMapper.insertId(userInfo);
        selectAll();
    }

    @Test
    void getLikeList() {
        List<UserInfo> list = userInfoMapper.getLikeList("i");
        System.out.println(list.toString());
    }

    @Transactional
    @Test
    void add2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("虾虾");
        userInfo.setPassword("132520");
        userInfo.setAge(35);
        userInfo.setGender(1);
        userInfo.setPhone("58465132");
        userInfoMapper.add2(userInfo);
        selectAll();
    }

    @Test
    void add3() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("gashtjh");
        userInfo.setPassword("132520");
        userInfo.setAge(35);
        userInfo.setGender(1);
        userInfoMapper.add3(userInfo);
    }

    @Test
    void getListByWhere() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(11);
        userInfo.setUsername("gashtjh");
        userInfo.setPassword("132520");
        userInfo.setAge(35);
        userInfo.setGender(1);
        UserInfo userInfo1 = userInfoMapper.getListByWhere(userInfo);
        System.out.println(userInfo1.toString());
    }

    @Test
    void update2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(11);
        userInfo.setUsername("鹤道人");
        userInfo.setPassword("46523g");
        userInfoMapper.update2(userInfo);
    }

    @Transactional
    @Test
    void delByIds() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        userInfoMapper.delByIds(list);
    }
}