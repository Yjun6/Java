package com.example.mq.mqserver.core;

import java.io.Serializable;
import java.util.UUID;

/**
 * 一个要传递的消息  属性 正文
 * 进行序列化和反序列化
 */
public class Message implements Serializable {
    //这两是Message最核心的部分
    private BasicProperties basicProperties = new BasicProperties();
    private Byte[] body;

    //辅助用的属性
    //message储存在文件中，需要使用偏移量来表示 [offsetBeg,offsetEnd)
    //transient可以帮助我们使这个属性不被序列化
    //offsetBeg offsetEnd 都是帮助我们在文件中快速找到数据，所以不要序列化存储
    private transient long offsetBeg = 0;//消息数据的开头距离文件开头的位置偏移(字节
    private transient long offsetEnd = 0;//消息数据的结尾距离文件开头的位置偏移(字节
    //表示是否是有效  0x1 有效  0x0 无效
    private byte isValid = 0x1;

    //使用工厂设计模式，让工厂方法帮我们封装创建Message对象的过程
    //会自动生成唯一的MessageId
    //如果routingKey和basicProperties里的routingKey冲突，以用户传输的为准
    public static Message createMessageWithId(String routingKey, BasicProperties basicProperties, Byte[] body) {
        Message message = new Message();
        if (basicProperties != null) {
            message.setBasicProperties(basicProperties);
        }
        //生成MessageId 以M-为前缀
        message.setMessageId("M-"+ UUID.randomUUID());
        message.setRoutingKey(routingKey);
        message.body = body;
        return message;
    }

    public String getMessageId() {
        return basicProperties.getMassageId();
    }

    public String getRoutingKey() {
        return basicProperties.getRoutingKey();
    }

    public int getDeliverMode() {
        return basicProperties.getDeliverMode();
    }

    public void setMessageId(String messageId) {
        basicProperties.setMassageId(messageId);
    }

    public void setRoutingKey(String routingKey) {
        basicProperties.setRoutingKey(routingKey);
    }

    public void setDeliverMode(int deliverMode) {
        basicProperties.setDeliverMode(deliverMode);
    }

    public BasicProperties getBasicProperties() {
        return basicProperties;
    }

    public void setBasicProperties(BasicProperties basicProperties) {
        this.basicProperties = basicProperties;
    }

    public Byte[] getBody() {
        return body;
    }

    public void setBody(Byte[] body) {
        this.body = body;
    }

    public long getOffsetBeg() {
        return offsetBeg;
    }

    public void setOffsetBeg(long offsetBeg) {
        this.offsetBeg = offsetBeg;
    }

    public long getOffsetEnd() {
        return offsetEnd;
    }

    public void setOffsetEnd(long offsetEnd) {
        this.offsetEnd = offsetEnd;
    }

    public byte getIsValid() {
        return isValid;
    }

    public void setIsValid(byte isValid) {
        this.isValid = isValid;
    }
}
