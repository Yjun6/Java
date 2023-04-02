import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int red = random.nextInt(33) + 1;//[1,33]
        int blue = random.nextInt(16) + 1;//[1,16]
        System.out.println("生成双色球:");
        System.out.printf("红球：%02d\n", red);
        System.out.printf("篮球：%02d\n", blue);
    }
}