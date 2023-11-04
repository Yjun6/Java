package com.example.demo.ioc.v2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-03
 * Time:22:08
 */
public class Main {
    public static void main(String[] args) {
        Tire2 tire2 = new Tire2(17, "red");
        Bottom2 bottom2 = new Bottom2(tire2);
        FrameWork2 frameWork2 = new FrameWork2(bottom2);
        Car car = new Car(frameWork2);
        car.run();
    }
}
