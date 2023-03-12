import java.util.Scanner;
import java.util.Arrays;
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
        System.out.print("请输入您需要的数组大小：");
        //num->保存数组元素个数
        int num = scan.nextInt();
        int[] arr = new int[num];
        System.out.println("请输入您需要排序的数组元素：");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }

        sort(arr);
        System.out.println("调整后：" + Arrays.toString(arr));
    }

    public static void sort(int[] array){
        //调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
        //如数组：[1,2,3,4,5,6]
        //调整后可能是：[1, 5, 3, 4, 2, 6]
        //左边起始下标
        int left = 0;
        //右边终止下标
        int right = array.length - 1;
        while(left < right){
            //奇数不发生改变
            while( array[left] % 2 != 0){
                left++;
            }
            //偶数不发生改变
            while( array[right] % 2 == 0){
                right--;
            }
            //奇偶转换
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            right--;
            left++;
        }
    }
}