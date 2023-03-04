import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-04
 * Time:22:02
 */
public class GuessPrimeNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int userNumber = scan.nextInt();

        int i = 0;
        for ( i = 2; i <= Math.sqrt(userNumber); i++) {
            if(userNumber % i == 0){
                    System.out.println(userNumber + "不是素数");
                    break;
            }
        }
        if(i > Math.sqrt(userNumber)){
            System.out.println(userNumber + "是素数");
        }


    }
}
