import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-12
 * Time:12:23
 */
public class MostElements {
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
        //判断数组
        int ret = mostElements(array);
        //判断是否有符合要求的元素
        if(ret == -1){
            System.out.println("没有符合要求的元素");
        }else{
            System.out.println( "找到了：" + array[ret] );
        }
    }

    public static int mostElements(int[] arr){
        //fre数组存储arr数组中数值出现的次数
        //出现一次，数值最原始位置+1，其他赋值为-1
        int[] fre = new int[arr.length];
        //计算数值出现的频率
        for (int i = 0; i < arr.length - 1; i++) {
            //当arr[i]不是该数值最原始位置时，跳过该位置
            if(fre[i] == -1){
                continue;
            }
            //该数值第一次出现在arr数组中
            fre[i]++;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] == arr[j]){
                    fre[i]++;
                    fre[j] = -1;
                }
            }
            //提前满足题意
            if(fre[i] > arr.length / 2){
                return arr[i];
            }
        }
        //没有符合题意的值
        return -1;
    }
}
