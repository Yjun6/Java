package com.add;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-04-10
 * Time:16:30
 */
public class Truck {
    ComputerWeight arr[];

    public Truck() {
        arr = new ComputerWeight[]{
                new Television(),
                new Computer(),
                new WashMachine()
        };
    }

}
