package com.example.mq.mqserver.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    private Map<String,Object> argument = new HashMap<>();

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

    public String getArgument() {
        try {
            return (new ObjectMapper()).writeValueAsString(argument);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "{}";
    }

    public void setArgument(String argument) {
        try {
            this.argument = (new ObjectMapper()).readValue(argument, new TypeReference<HashMap<String, Object>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void setArgument(String key,Object value) {
        this.argument.put(key,value);
    }

    public Object getArgumentValue(String key) {
        return this.argument.get(key);
    }
}
