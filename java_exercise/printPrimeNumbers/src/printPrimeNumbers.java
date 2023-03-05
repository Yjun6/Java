/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-04
 * Time:22:02
 */
public class printPrimeNumbers {

    public static void main(String[] args) {

        for (int i = 2; i <= 100; i++) {
            int result = 1;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0){
                    result = 0;
                    break;
                }
            }
            if(result == 1){
                System.out.println(i);
            }
        }
    }
}