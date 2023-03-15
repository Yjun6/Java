import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-12
 * Time:12:23
 */
public class MostElements2 {
    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * */
    public static void main(String[] args) {
        System.out.print("请输入您需要的数组大小：");
        //用户输入，决定数组元素个数
        Scanner scan = new Scanner(System.in);
        int userInput = scan.nextInt();

        System.out.println("请输入您需要判断的数组元素：");
        //输入数组
        int[] array = new int[userInput];
        for (int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }
        //判断数组  肯定会有值满足题意
        int ret = mostElements(array);
        System.out.println( "找到了：" + array[ret] );
    }

    public static int mostElements(int[] arr){
        //排序
        Arrays.sort(arr);
        //求值
        return arr.length / 2;
    }
}
