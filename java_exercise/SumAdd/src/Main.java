import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println( sum(n) );
    }

    public static int sum(int n){
        if(n == 1){
            return 1;
        }else{
            return n + sum( n - 1 );
        }
    }
}