import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    /**
     * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况
     * 如果存在，请返回 true ；否则，返回 false
     * */
    public static void main(String[] args){
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

        System.out.print("对于该输入的数组的判断结果是：" + findOldNumber(array) );
    }

    public static boolean findOldNumber(int[] array){
        for (int i = 0; i < array.length - 2; i++) {
            int j = i;
            for (; j < i + 3; j++) {
                //如果array[j]为偶数，跳过当前循环
                if(array[j] % 2 == 0){
                    break;
                }
            }
            //满足存在连续三个元素都是奇数的情况
            if(j == i + 2){
                return true;
            }
        }
        //不满足存在连续三个元素都是奇数的情况
        return false;
    }
}