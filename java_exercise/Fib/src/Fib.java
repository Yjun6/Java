import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-07
 * Time:22:37
 */
public class Fib {
    public static void main(String[] args) {
        //求斐波那契数列的第n项。(迭代实现)
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println( fib(n) );
    }

    public static int fib(int num){
        if(num == 1){
            return 0;
        }else if(num == 2){
            return 1;
        }

        int sum = 0;
        int f1 = 0;
        int f2 = 1;
        while(num > 2){
            sum = f1 + f2;
            f1 = f2;
            f2 = sum;
            num--;
        }
        return sum;
    }
}
