package Test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-22
 * Time:20:53
 */
abstract class Refrigerator implements IPower,IPowerConsumptionLever{
    String made;
    int madeYear;

    public Refrigerator(String made, int madeYear) {
        this.made = made;
        this.madeYear = madeYear;
    }
}