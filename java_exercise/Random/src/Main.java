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
        int random1 = 0;
        do{
            random1 = random.nextInt(1000000);//[0,1000000)
        }while(!(random1>=100000 && random1<1000000));
        System.out.println(random1);
    }
}