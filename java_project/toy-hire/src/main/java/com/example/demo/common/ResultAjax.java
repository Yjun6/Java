package com.example.demo.common;

import lombok.Data;
/**
 * 前后端返回的统一对象
 * */
@Data
public class ResultAjax {
    private int code;
    private String msg;
    private Object data;

    public static ResultAjax succ(Object data) {
        ResultAjax resultAjax = new ResultAjax();
        resultAjax.setCode(200);
        resultAjax.setData(data);
        resultAjax.setMsg("");
        return resultAjax;
    }

    public static ResultAjax succ(int code, String msg, Object data) {
        ResultAjax resultAjax = new ResultAjax();
        resultAjax.setCode(code);
        resultAjax.setData(data);
        resultAjax.setMsg(msg);
        return resultAjax;
    }

    public static ResultAjax fail(int code, String msg) {
        ResultAjax resultAjax = new ResultAjax();
        resultAjax.setCode(code);
        resultAjax.setData(null);
        resultAjax.setMsg(msg);
        return resultAjax;
    }

    public static ResultAjax fail(int code, String msg, Object data) {
        ResultAjax resultAjax = new ResultAjax();
        resultAjax.setCode(code);
        resultAjax.setData(data);
        resultAjax.setMsg(msg);
        return resultAjax;
    }
}
