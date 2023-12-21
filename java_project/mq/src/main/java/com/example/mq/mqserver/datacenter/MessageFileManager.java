package com.example.mq.mqserver.datacenter;

import java.io.*;
import java.util.Scanner;

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

    //读消息统计文件
    private Stat readStat(String queueName) {
        Stat stat = new Stat();
        try (InputStream inputStream = new FileInputStream(getQueueStatPath(queueName))){
            Scanner scanner = new Scanner(inputStream);
            stat.totalCount = scanner.nextInt();
            stat.validCount = scanner.nextInt();
            return stat;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //写消息统计文件
    private void writeStat(String queueName, Stat stat) {
        try(OutputStream outputStream = new FileOutputStream(getQueueStatPath(queueName))) {
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write(stat.totalCount+"\t"+stat.validCount);
            printWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
