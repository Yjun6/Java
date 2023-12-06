package com.example.mq.mqserver.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * 交换机
 */
public class Exchange {

    //name作为交换机的身份标识
    private String name;
    //交换机类型 DIRECT FANOUT TOPIC
    private ExchangeType type = ExchangeType.DIRECT;
    //是否是持久化存储 true 需要持久化 false 不必持久化存储
    private Boolean durable  = false;
    //如果当前交换机没人使用，自动删除
    //暂时没完善（RabbitMQ)有这个功能
    private Boolean autoDelete  = false;
    //一些额外的参数 暂时没完善
    //为了储存argument，需要把map转成json格式，再存到数据库里面
    private Map<String,Object> argument = new HashMap<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExchangeType getType() {
        return type;
    }

    public void setType(ExchangeType type) {
        this.type = type;
    }

    public Boolean getDurable() {
        return durable;
    }

    public void setDurable(Boolean durable) {
        this.durable = durable;
    }

    public Boolean getAutoDelete() {
        return autoDelete;
    }

    public void setAutoDelete(Boolean autoDelete) {
        this.autoDelete = autoDelete;
    }

    public String getArgument() {
        //把当前argument参数，从Map转成String类型(JSON)
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(argument);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //如果代码抛出异常，返回一个空的JSON字符串
        return "{}";
    }

    //从数据库读数据之后，构造Exchange对象，会自动调用这个set
    public void setArgument(String argument) {
        //解析
    }
}
