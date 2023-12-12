package com.example.demo.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常的统一处理
 */
//@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public ResultAjax doException(Exception e) {
        return ResultAjax.fail(-1,e.getMessage());
    }
}
