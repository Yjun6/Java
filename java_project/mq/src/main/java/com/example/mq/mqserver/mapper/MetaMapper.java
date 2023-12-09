package com.example.mq.mqserver.mapper;

import com.example.mq.mqserver.core.Binding;
import com.example.mq.mqserver.core.Exchange;
import com.example.mq.mqserver.core.MSGQueue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * SQLite数据库的mapper
 */
@Mapper
public interface MetaMapper {
    //提供三个核心建表的方法
    void createExchangeTable();
    void createQueueTable();
    void createBindingTable();

    //针对上述三个表，进行 插入 和 删除 查找
    void insertExchange(Exchange exchange);
    void deleteExchange(String exchangeName);
    List<Exchange> selectAllExchange();
    void insertQueue(MSGQueue msgQueue);
    void deleteQueue(String queueName);
    List<MSGQueue> selectAllMSGQueue();
    void insertBinding(Binding binding);
    void deleteBinding(Binding binding);
    List<Binding> selectAllBinding();
}
