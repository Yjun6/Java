package com.example.demo.model;

import com.example.demo.common.Constants;
import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private String errorMsg;
    private T data;

    // 成功
    public static <T> Result<T> success(T data) {
        Result result = new Result();
        result.setCode(Constants.RESULT_SUCCESS);
        result.setData(data);
        result.setErrorMsg("");
        return result;
    }

    //失败
    public static <T> Result<T> fail(String errorMsg) {
        Result result = new Result();
        result.setCode(Constants.RESULT_FAIL);
        result.setErrorMsg(errorMsg);
        return result;
    }

    // 虽然失败  但是仍然会返回一些数据
    public static <T> Result<T> fail(String errorMsg, T data) {
        Result result = new Result();
        result.setCode(Constants.RESULT_FAIL);
        result.setErrorMsg(errorMsg);
        result.setData(data);
        return result;
    }
}
