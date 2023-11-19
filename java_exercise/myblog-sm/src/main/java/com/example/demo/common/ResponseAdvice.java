package com.example.demo.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 保底统一返回值处理
 */
@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof ResultAjax) {
            return body;
        }
        if (body instanceof String) {
            //String需要单独处理
            ResultAjax resultAjax = ResultAjax.succ(body);
            try {
                return objectMapper.writeValueAsString(resultAjax);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return ResultAjax.succ(body);
    }
}
