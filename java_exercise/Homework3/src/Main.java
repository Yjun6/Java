/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    public static void main(String[] args) {
        Chinese chinese = new Chinese();
        chinese.speakHello();
        American american = new American();
        american.speakHello();
        chinese.speakHello();
        chinese.averageHeight();
        american.averageHeight();
        Beijingman beijingman = new Beijingman();
        beijingman.averageHeight();
    }
}