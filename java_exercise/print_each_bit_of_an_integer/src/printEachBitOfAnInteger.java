import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-05
 * Time:13:12
 */
public class printEachBitOfAnInteger {
    public static void main(String[] args) {
        //输出一个整数的每一位，如：123的每一位是3，2，1
        Scanner scan = new Scanner(System.in);
        int UserInput = scan.nextInt();
        //UserInput == 0
        if(UserInput == 0){
            System.out.println( UserInput);
        }
        // UserInput != 0
        while(UserInput != 0){
            System.out.print(UserInput % 10 + "  ");
            UserInput /= 10;
        }

    }
}
