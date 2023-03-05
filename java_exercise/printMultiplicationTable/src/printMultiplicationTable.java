import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-05
 * Time:12:59
 */
public class printMultiplicationTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int UserInput = scan.nextInt();
        for (int i = 1; i <= UserInput; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "   ");
            }
            System.out.println();
        }
    }
}
