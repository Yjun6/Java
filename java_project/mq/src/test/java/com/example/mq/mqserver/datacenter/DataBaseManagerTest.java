package com.example.mq.mqserver.datacenter;

import com.example.mq.MqApplication;
import com.example.mq.mqserver.core.Binding;
import com.example.mq.mqserver.core.Exchange;
import com.example.mq.mqserver.core.ExchangeType;
import com.example.mq.mqserver.core.MSGQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    void init() {
        List<Exchange> exchangeList = dataBaseManager.selectAllExchange();
        List<MSGQueue> queueList = dataBaseManager.selectAllMSGQueue();
        List<Binding> bindingList = dataBaseManager.selectAllBinding();

        //使用sout方法不如断言 断言的解释更清晰
        //没有数据的打印就是代表正确
        Assertions.assertEquals(1,exchangeList.size());
        Assertions.assertEquals("",exchangeList.get(0).getName());
        Assertions.assertEquals(ExchangeType.DIRECT,exchangeList.get(0).getType());
        Assertions.assertEquals(0,queueList.size());
        Assertions.assertEquals(0,bindingList.size());
    }










}