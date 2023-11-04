package com.example.demo.ioc.v2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-03
 * Time:22:03
 */
public class Bottom2 {
    private Tire2 tire2;

    public Bottom2(Tire2 tire2) {
        this.tire2 = tire2;
        System.out.println("bottom2 init...");
    }
}
