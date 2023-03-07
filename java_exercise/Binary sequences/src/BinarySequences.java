import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-06
 * Time:21:18
 */
public class BinarySequences {
    public static void main(String[] args) {
        //获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列
        Scanner scan = new Scanner(System.in);
        //用户输入
        int userInput = scan.nextInt();

        //打印用户输入值的偶数
        printEven(userInput);
        //打印用户输入值的奇数
        printOdd(userInput);
    }

    public static void printEven(int num){
        for (int i = 31; i >= 1; i -= 2) {
            System.out.print(((num>>>i) & 1 ) + " ");
        }
        System.out.println();
    }

    public static void printOdd(int num){
        for (int i = 30; i >= 0; i -= 2) {
            System.out.print(((num>>>i) & 1 ) + " ");
        }
        System.out.println();
    }
}
