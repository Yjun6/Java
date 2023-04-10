package com.add;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-04-10
 * Time:16:41+
 *
 */
public class Main1 {
    public static void main(String[] args) {
        Truck truck = new Truck();
        double sumAll = 0.0;
        for (int i = 0; i < truck.arr.length; i++) {
            sumAll += truck.arr[i].computerSales();
        }
        System.out.println("货车装载货物重量为："+sumAll);

        double sum = 0.0;
        for (int i = 0; i < truck.arr.length; i++) {
            sum += truck.arr[i].computerWeight();
        }
        System.out.println("火车卸载后，");
        System.out.println("货车装载货物重量为："+(sumAll-sum));
    }
}
