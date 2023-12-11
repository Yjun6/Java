package com.example.mq.mqserver.datacenter;

/**
 * 消息管理
 */
public class MessageFileManager {

    //用来对队列进行统计
    static public class Stat {
        public int totalCount;//总消息数
        public int validCount;//有效消息数
    }

    //获取保存消息的二进制文件的方法
    //目录
    private String getQueueDir(String queueName) {
        return "./data/"+queueName;
    }

    //获取消息文件的目录 二进制文件
    private String getQueuePath(String queueName) {
        return getQueueDir(queueName) + "/queue_data.bin";
    }

    //获取保存消息的偏移量的目录
    private String getQueueStatPath(String queueName) {
        return getQueueDir(queueName) + "/queue_stat.txt";
    }
}
