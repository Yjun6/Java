package com.example.mq.mqserver.datacenter;

import com.example.mq.MqApplication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 数据库管理那个类的测试方法
 */
@SpringBootTest
class DataBaseManagerTest {

    //
    private DataBaseManager dataBaseManager = new DataBaseManager();


    //每次测试之前创建数据库
    @BeforeEach
    public void befor() {
        MqApplication.context = SpringApplication.run(MqApplication.class);
        dataBaseManager.init();
    }

    //每次使用完测试方法之后都要对数据库进行删除
    //本质是删除文件
    @AfterEach
    public void after() {
        //再删除文件之前，需要再次手动关闭context
        MqApplication.context.close();
        dataBaseManager.delete();
    }

}