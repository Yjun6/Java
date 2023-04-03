/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-04-03
 * Time:16:15
 */
public class American extends People {
    public void americanBoxing(){
        System.out.println("hohohoho");
    }

    @Override
    public void speakHello() {
        System.out.println("How do you do?");
    }

    @Override
    public void averageHeight() {
        System.out.println("American's average height:176cm");
    }

    @Override
    public void averageWeight() {
        System.out.println("American's average weight:70kg");
    }
}
