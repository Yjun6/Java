package com.example.demo.config;

import com.example.demo.common.Constants;
import com.example.demo.model.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 */
@ResponseBody
@ControllerAdvice
public class ErrorAdvice {
    @ExceptionHandler
    public Result errorHandler(Exception e) {
        Result result = new Result();
        result.setErrorMsg("内部发生异常，请联系管理员");
        result.setCode(Constants.RESULT_FAIL);
        return result;
    }
}
