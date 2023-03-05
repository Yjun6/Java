import java.util.Random;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-03
 * Time:21:12
 */
public class GuessNumbers {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        //生成一个随机数
        int randomNumber = random.nextInt(100);//[0,100)
        //作弊
        System.out.println("作弊：" + randomNumber);
        while(true){
            int number = scan.nextInt();
            if(number > randomNumber){
                System.out.println("该值偏大");
            }else if(number < randomNumber){
                System.out.println("该值偏小");
            }else{
                System.out.println("猜测正确");
                break;
            }
        }

    }

}
