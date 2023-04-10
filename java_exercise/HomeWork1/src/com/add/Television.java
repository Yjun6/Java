package com.add;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-04-10
 * Time:16:15
 */
public class Television implements ComputerTotalSales,ComputerWeight{
    @Override
    public double computerSales() {
        return 5562.45;
    }

    @Override
    public double computerWeight() {
        return 498.5;
    }
}
