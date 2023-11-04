package com.example.demo.ioc.v1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-03
 * Time:21:48
 */
public class Tire {
    private int size;

    public Tire(int size) {
        this.size = size;
        System.out.println("tire inti...size" + size);
    }
}
