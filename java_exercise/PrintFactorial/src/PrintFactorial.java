import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-07
 * Time:22:22
 */
public class PrintFactorial {

    public static void main(String[] args) {
        // 求 N 的阶乘 。
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(Factorial(n) );
    }

    public static int Factorial(int num){
        if(num == 0){
            return 1;
        }else{
            return num * Factorial(num-1);
        }
    }
}
