package Test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-22
 * Time:20:55
 */
public class Main {
    public static void useRef(Refrigerator refrigerator){
        refrigerator.power();
        refrigerator.powerConsumptionLever();
    }

    public static void main(String[] args) {
        useRef(new Geli("小美", 2019));
        useRef(new Meide("小格",2020));
    }
}
