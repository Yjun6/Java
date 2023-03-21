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
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if(a > b){
            System.out.print(a + b + " " + (a - b) + " " + a * b + " " + a / b + " " + a % b);
        }else{
            System.out.print(a + b + " " + (b - a) + " " + a * b + " " + b / a + " " + b % a);
        }
    }
}