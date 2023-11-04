package com.example.demo.ioc.v2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-03
 * Time:22:03
 */
public class Tire2 {
    private int size;
    private String color;

    public Tire2(int size, String color) {
        this.size = size;
        this.color = color;
        System.out.println("tire2 inti...size  " + size);
        System.out.println("tire2 inti...color  " + color);
    }
}
