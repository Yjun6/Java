package com.add;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-04-10
 * Time:16:16
 */
public class WashMachine implements ComputerTotalSales,ComputerWeight{

    @Override
    public double computerWeight() {
        return 164.5;
    }

    @Override
    public double computerSales() {
        return 486;
    }
}
