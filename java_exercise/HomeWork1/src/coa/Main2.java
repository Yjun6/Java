package coa;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-04-10
 * Time:16:54
 */
public class Main2 {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.setState(new DogEE());
        dog1.show();

        Dog dog2 = new Dog();
        dog2.setState(new DogWW());
        dog2.show();
    }
}
