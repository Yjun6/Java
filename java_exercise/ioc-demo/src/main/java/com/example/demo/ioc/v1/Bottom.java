package com.example.demo.ioc.v1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-03
 * Time:21:47
 */
public class Bottom {
    private Tire tire;

    public Bottom(int size) {
        tire = new Tire(size);
        System.out.println("bottom init...");
    }
}
