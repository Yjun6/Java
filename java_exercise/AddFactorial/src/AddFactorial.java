import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-07
 * Time:23:11
 */
public class AddFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(addFactorial(n) );
    }

    public static int addFactorial(int num){
        //求1！+2！+3！+4！+........+n!的和
        if(num == 0){
            return 1;
        }

        int sum = 0;
        while( num > 0){
            sum += factorial(num);
            num--;
        }
        return sum;
    }

    public static int factorial(int num) {
        if(num == 0){
            return 1;
        }else{
            return num * factorial(num-1);
        }
    }

}
