package com.example.mq.mqserver.mapper;

import com.example.mq.mqserver.core.Binding;
import com.example.mq.mqserver.core.Exchange;
import com.example.mq.mqserver.core.MSGQueue;
import org.apache.ibatis.annotations.Mapper;

/**
 * SQLite数据库的mapper
 */
@Mapper
public interface MetaMapper {
    //提供三个核心建表的方法
    void createExchangeTable();
    void createQueueTable();
    void createBindingTable();

    //针对上述三个表，进行 插入 和 删除
    void insertExchange(Exchange exchange);
    void deleteExchange(String exchangeName);
    void insertQueue(MSGQueue msgQueue);
    void deleteQueue(String queueName);
    void insertBinding(Binding binding);
    void deleteBinding(Binding binding);
}
