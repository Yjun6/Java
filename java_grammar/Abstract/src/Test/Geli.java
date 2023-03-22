package Test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-22
 * Time:20:53
 */
public class Geli extends Refrigerator {
    public Geli(String made, int madeYear) {
        super(made, madeYear);
    }

    @Override
    public void power() {
        System.out.println("格力 功率为：" + 156);
    }

    @Override
    public void powerConsumptionLever() {
        System.out.println("格力 耗电等级为：3级");
    }
}
