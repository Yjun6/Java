package com.example.demo.ioc.v1;

import com.example.demo.ioc.v1.Car;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-03
 * Time:21:44
 */
public class Main {
    public static void main(String[] args) {
        Car car = new Car(17);
        car.run();
    }
}
