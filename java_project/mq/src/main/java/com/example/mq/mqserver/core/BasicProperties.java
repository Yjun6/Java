package com.example.mq.mqserver.core;

public class BasicProperties {
    //消息的唯一身份标识 UUID
    private String massageId;
    //和bindingKey做匹配
    //当前交换机类型是DIRECT，rountingKey表示要转发的队列名
    //当前交换机类型是FANOUT，              无意义（不使用）
    //当前交换机类型是TOPIC ，              要和bindingKey做匹配，符合要求才能转发给队列
    private String routingKey;
    //表示这个消息是否要持久化，1 表示不持久化，2表示持久化
    private int deliverMode = 1;

    //在rabbitmq还有其他属性，这里暂时不写了


    public String getMassageId() {
        return massageId;
    }

    public void setMassageId(String massageId) {
        this.massageId = massageId;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public int getDeliverMode() {
        return deliverMode;
    }

    public void setDeliverMode(int deliverMode) {
        this.deliverMode = deliverMode;
    }
}
