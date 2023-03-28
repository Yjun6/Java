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
        String arr = scanner.nextLine();
        String[] ret = arr.split(" ");
        System.out.println(ret.length);
    }
}