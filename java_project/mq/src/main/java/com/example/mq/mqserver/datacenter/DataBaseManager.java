package com.example.mq.mqserver.datacenter;

import com.example.mq.MqApplication;
import com.example.mq.mqserver.core.Binding;
import com.example.mq.mqserver.core.Exchange;
import com.example.mq.mqserver.core.ExchangeType;
import com.example.mq.mqserver.core.MSGQueue;
import com.example.mq.mqserver.mapper.MetaMapper;

import java.io.File;
import java.util.List;

/**
 * 对数据库进行管理
 */
public class DataBaseManager {
    private MetaMapper mapper;

    /*初始化数据库*/
    public void init() {
        //手动获取MetaMapper
        mapper = MqApplication.context.getBean(MetaMapper.class);

        if (!checkDBExists()) {
            //数据库不存在，就进行建库建表操作
            //建表
            createTable();
            //插入默认数据
            createDefaultData();
            System.out.println("[DataBaseManager] 数据库初始化完成！");
        } else {
            //数据库已经存在，不必做其他的
            System.out.println("[DataBaseManager] 数据库已经存在！");
        }
    }

    /*插入默认数据
    * rabbitmq : 带有一个匿名的交换机 类型是DIRECT
    * */
    public void createDefaultData() {
        //构造一个默认的交换机
        Exchange exchange = new Exchange();
        exchange.setName("");
        exchange.setType(ExchangeType.DIRECT);
        exchange.setDurable(true);
        exchange.setAutoDelete(false);
        mapper.insertExchange(exchange);
        System.out.println("[DataBaseManager] 创建初始数据完成！");
    }

    /*删除数据库
    * 本质是删除文件夹*/
    public void delete() {
        boolean ret = (new File("./data/meta.db")).delete();
        if (ret) {
            System.out.println("[DataBaseManager] 数据库文件夹删除完成！");
        } else {
            System.out.println("[DataBaseManager] 数据库文件夹删除失败！");
        }
//        //也要记得删除文件目录
//        //在删除目录之前必须保证目录是空的
//        boolean r = (new File("./data")).delete();
//        if (r) {
//            System.out.println("[DataBaseManager] 数据库文件目录删除完成！");
//        } else {
//            System.out.println("[DataBaseManager] 数据库文件目录删除失败！");
//        }
    }

    /*建表
    * 这里不需要建库，因为在首次执行这里时，mybatis已经帮我们完成了建库操作
    * */
    public void createTable() {
        mapper.createExchangeTable();
        mapper.createQueueTable();
        mapper.createBindingTable();
        System.out.println("[DataBaseManager] 创建表完成！");
    }

    /*检测数据库是否存在，即检测文件是否存在*/
    private boolean checkDBExists() {
        //主要是判断    url: jdbc:sqlite:./data/meta.db 这个是否存在
        return (new File("./data/meta.db").exists());
    }

    //对数据库其他的方法进行完成
    public void deleteExchange(String exchangeName) {
        mapper.deleteExchange(exchangeName);
    }

    public void insertQueue(MSGQueue msgQueue) {
        mapper.insertQueue(msgQueue);
    }

    public List<Exchange> selectAllExchange() {
        return mapper.selectAllExchange();
    }

    public void deleteQueue(String queueName) {
        mapper.deleteQueue(queueName);
    }

    public  List<MSGQueue> selectAllMSGQueue() {
        return mapper.selectAllMSGQueue();
    }

    public void insertBinding(Binding binding) {
        mapper.insertBinding(binding);
    }

    public void deleteBinding(Binding binding) {
        mapper.deleteBinding(binding);
    }

    public List<Binding> selectAllBinding() {
        return mapper.selectAllBinding();
    }

}
