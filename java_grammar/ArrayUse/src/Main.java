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
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        //求数组的长度
        System.out.println(arr1.length);

        //i = arr1[ ]
        for (int i : arr1) {
            System.out.print(i + "  ");
        }
        System.out.println();

        //java打印数组的便捷方法
        System.out.println( Arrays.toString(arr1) );
        //动态数组的创建
        int a=4;
        int b=4;
        int[][] arr = new int[a][b];

    }
}