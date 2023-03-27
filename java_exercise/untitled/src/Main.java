import java.util.Arrays;
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
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(arr));
        System.out.println("请输入：");
        int i = scanner.nextInt();
        int j = 0;
        for (;j<arr.length;j++){
                if(i == arr[j]){
                    System.out.println("找到了");
                    return;
            }
        }
        System.out.println("没找到");

    }
}