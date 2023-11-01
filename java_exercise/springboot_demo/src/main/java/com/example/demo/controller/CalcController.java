package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-01
 * Time:21:00
 */
@RequestMapping("/calc")
@Controller
public class CalcController {

    @RequestMapping("/sum")
    @ResponseBody
    public String sum(Integer num1, Integer num2) {
        System.out.println("==========================sum///");
        Integer sum = num1 + num2;
        return "计算结果为：" + sum;
    }


}
