package com.example.mq.mqserver.core;

/**
 * 交换机类型
 */
public enum ExchangeType {
    DIRECT(0),
    FANOUT(1),
    TOPIC(2);

    private final int type;

    private ExchangeType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
