package com.example.mq.mqserver.core;

import java.util.HashMap;
import java.util.Map;

/**
 * 存储消息的队列
 * MSG Message
 */
public class MSGQueue {
    //name作为唯一的身份标识
    private String name;
    //是否是持久化存储 true 需要持久化 false 不必持久化存储
    private Boolean durable  = false;
    //表示是否是这个队列只能被一个消费者使用 false 其他消费者也能使用
    //暂时没完善
    private Boolean exclusive = false;
    //自动删除 没人使用就删除false 表示不会自动删除  true表示删除
    private Boolean autoDelete = false;
    //扩展参数暂时没实现
    private Map<String,Object> arguments = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDurable() {
        return durable;
    }

    public void setDurable(Boolean durable) {
        this.durable = durable;
    }

    public Boolean getExclusive() {
        return exclusive;
    }

    public void setExclusive(Boolean exclusive) {
        this.exclusive = exclusive;
    }

    public Boolean getAutoDelete() {
        return autoDelete;
    }

    public void setAutoDelete(Boolean autoDelete) {
        this.autoDelete = autoDelete;
    }

    public Map<String, Object> getArguments() {
        return arguments;
    }

    public void setArguments(Map<String, Object> arguments) {
        this.arguments = arguments;
    }
}
