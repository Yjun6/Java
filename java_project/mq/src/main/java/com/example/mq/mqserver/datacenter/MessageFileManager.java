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

    //创建队列的目录和文件
    public void createQueue(String queueName) throws IOException {
        File file = new File(getQueueDir(queueName));
        if(!file.exists()) {
            boolean ret = file.mkdir();
            if (!ret) {
                //没有创建成功
                throw new IOException(queueName+"目录创建失败");
            }
        }
        //1.创建队列数据文件
        File queueDateFile = new File(getQueuePath(queueName));
        if (!queueDateFile.exists()) {
            boolean ok = queueDateFile.createNewFile();
            if (!ok) {
                throw new IOException("创建文件失败！queueDateFile="+queueDateFile.getAbsolutePath());
            }
        }
        //2.创建消息统计文件
        File queueStatFile = new File(getQueueStatPath(queueName));
        if (!queueStatFile.exists()) {
            boolean ok = queueStatFile.createNewFile();
            if (!ok) {
                throw new IOException("创建文件失败！queueDataFile="+queueStatFile.getAbsolutePath());
            }
        }
        //3.默认的消息统计文件数值
        Stat stat = new Stat();
        stat.validCount = 0;
        stat.totalCount = 0;
        writeStat(queueName,stat);
    }

    //删除队列的目录和文件
    //先删文件，再删统计文件 再是目录
    public void destroyQueueFiles(String queueName) throws IOException {
        File queueDateFile = new File(getQueuePath(queueName));
        boolean ok1 = queueDateFile.delete();
        File queueStatFile = new File(getQueueStatPath(queueName));
        boolean ok2 = queueStatFile.delete();
        File queue = new File(getQueueDir(queueName));
        boolean ok3 = queue.delete();
        if (!(ok1 && ok2 && ok3)) {
            throw new IOException("队列文件删除失败！ queueDir="+getQueueDir(queueName));
        }
    }

    //检测队列的目录和文件是否存在
    public boolean existQueue(String queueName) {
        File queueStatFile = new File(getQueueStatPath(queueName));
        File queueDateFile = new File(getQueuePath(queueName));
        if (queueDateFile.exists() || queueStatFile.exists()) {
            return true;
        }
        return false;
    }
}
