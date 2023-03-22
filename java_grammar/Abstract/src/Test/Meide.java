package Test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-22
 * Time:20:10
 */

public class Meide extends Refrigerator{
    public Meide(String made, int madeYear) {
        super(made, madeYear);
    }

    @Override
    public void power() {
        System.out.println("美的 功率为："+130);
    }

    @Override
    public void powerConsumptionLever() {
        System.out.println("美的 耗电等级为：2级");
    }
}

