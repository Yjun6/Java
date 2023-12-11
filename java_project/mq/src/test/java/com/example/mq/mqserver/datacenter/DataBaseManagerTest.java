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
    void initTest() {
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

    @Test
    void insertExchangeTest() {
        //构造一个交换机
        Exchange exchange = new Exchange();
        exchange.setName("TestExchange");
        exchange.setDurable(true);
        exchange.setType(ExchangeType.DIRECT);
        exchange.setArgument("aaa",123);
        exchange.setAutoDelete(false);
        //插入进去
        dataBaseManager.insertExchange(exchange);
        //测试是否插入成功 已经拥有一个默认的交换机
        List<Exchange> exchangeList = dataBaseManager.selectAllExchange();
        Assertions.assertEquals(2,exchangeList.size());
        Assertions.assertEquals("TestExchange",exchangeList.get(1).getName());
        Assertions.assertEquals(ExchangeType.DIRECT,exchangeList.get(1).getType());
        Assertions.assertEquals(true,exchangeList.get(1).getDurable());
        Assertions.assertEquals(false,exchangeList.get(1).getAutoDelete());
        Assertions.assertEquals(123,exchangeList.get(1).getArgumentValue("aaa"));
    }

    @Test
    void deleteExchangeTest() {
        //构造一个交换机
        Exchange exchange = new Exchange();
        exchange.setName("TestExchange");
        exchange.setDurable(true);
        exchange.setType(ExchangeType.DIRECT);
        exchange.setArgument("aaa",123);
        exchange.setAutoDelete(false);
        //插入进去
        dataBaseManager.insertExchange(exchange);
        //测试是否插入成功 已经拥有一个默认的交换机
        List<Exchange> exchangeList = dataBaseManager.selectAllExchange();
        Assertions.assertEquals(2,exchangeList.size());
        //删除交换机
        dataBaseManager.deleteExchange("TestExchange");
        //测试删除是否成功
        exchangeList = dataBaseManager.selectAllExchange();
        Assertions.assertEquals(1,exchangeList.size());
        Assertions.assertEquals("",exchangeList.get(0).getName());
    }

    @Test
    void insertQueueTest() {
        MSGQueue msgQueue = new MSGQueue();
        msgQueue.setName("TestMSGQueue");
        msgQueue.setArgument("abc",123);
        msgQueue.setDurable(true);
        msgQueue.setExclusive(false);
        msgQueue.setAutoDelete(false);
        dataBaseManager.insertQueue(msgQueue);
        //测试是否插入成功
        List<MSGQueue> msgQueuesList = dataBaseManager.selectAllMSGQueue();
        Assertions.assertEquals(1,msgQueuesList.size());
        Assertions.assertEquals("TestMSGQueue",msgQueuesList.get(0).getName());
        Assertions.assertEquals(123,msgQueuesList.get(0).getArgumentValue("abc"));
        Assertions.assertEquals(true,msgQueuesList.get(0).getDurable());
        Assertions.assertEquals(false,msgQueuesList.get(0).getExclusive());
        Assertions.assertEquals(false,msgQueuesList.get(0).getAutoDelete());
    }

    @Test
    void deleteQueue() {
        //插入一个队列
        MSGQueue msgQueue = new MSGQueue();
        msgQueue.setName("TestMSGQueue");
        msgQueue.setArgument("abc",123);
        msgQueue.setDurable(true);
        msgQueue.setExclusive(false);
        msgQueue.setAutoDelete(false);
        dataBaseManager.insertQueue(msgQueue);
        //测试是否插入成功
        List<MSGQueue> msgQueuesList = dataBaseManager.selectAllMSGQueue();
        Assertions.assertEquals(1,msgQueuesList.size());
        Assertions.assertEquals("TestMSGQueue",msgQueuesList.get(0).getName());
        //删除队列
        dataBaseManager.deleteQueue("TestMSGQueue");
        msgQueuesList = dataBaseManager.selectAllMSGQueue();
        //测试是否删除成功
        Assertions.assertEquals(0,msgQueuesList.size());
    }

    @Test
    void insertBindingTest() {
        Binding binding = new Binding();
        binding.setBindingKey("BEKey");
        binding.setExchangeName("TestExchange");
        binding.setQueueName("TestQueue");
        //插入
        dataBaseManager.insertBinding(binding);
        //测试
        List<Binding> bindingList = dataBaseManager.selectAllBinding();
        Assertions.assertEquals(1,bindingList.size());
    }

    @Test
    void deleteBindingTest() {
        Binding binding = new Binding();
        binding.setBindingKey("BEKey");
        binding.setExchangeName("TestExchange");
        binding.setQueueName("TestQueue");
        //插入
        dataBaseManager.insertBinding(binding);
        //测试
        List<Binding> bindingList = dataBaseManager.selectAllBinding();
        Assertions.assertEquals(1,bindingList.size());
        //删除
        dataBaseManager.deleteBinding(binding);
        bindingList = dataBaseManager.selectAllBinding();
        Assertions.assertEquals(0,bindingList.size());
    }
}