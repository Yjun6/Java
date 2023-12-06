package com.example.mq.mqserver.mapper;

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

}
