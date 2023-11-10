package com.example.demo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-10
 * Time:16:19
 */
@Component
@ConfigurationProperties(prefix = "student")
@Data
public class Student{
    private Integer id;
    private String name;
    private Integer age;
}
