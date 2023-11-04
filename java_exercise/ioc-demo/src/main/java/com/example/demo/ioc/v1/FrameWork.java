package com.example.demo.ioc.v1;

import com.example.demo.ioc.v1.Bottom;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-03
 * Time:21:45
 */
public class FrameWork {
    private Bottom bottom;

    public FrameWork(int size) {
        bottom = new Bottom(size);
        System.out.println("framework init...");
    }
}
