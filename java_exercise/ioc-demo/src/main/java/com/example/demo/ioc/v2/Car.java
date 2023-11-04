package com.example.demo.ioc.v2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-03
 * Time:21:59
 */
public class Car {
    private FrameWork2 frameWork;

    public Car(FrameWork2 frameWork) {
        this.frameWork = frameWork;
        System.out.println("car init...");
    }

    public void run() {
        System.out.println("car run...");
    }
}
