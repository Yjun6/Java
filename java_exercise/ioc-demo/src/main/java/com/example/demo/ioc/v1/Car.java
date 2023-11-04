package com.example.demo.ioc.v1;

import com.example.demo.ioc.v1.FrameWork;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-03
 * Time:21:44
 */
public class Car {
    private FrameWork frameWork;

    public Car(int size) {
        frameWork = new FrameWork(size);
        System.out.println("car init...");
    }

    public void run() {
        System.out.println("car run...");
    }
}
