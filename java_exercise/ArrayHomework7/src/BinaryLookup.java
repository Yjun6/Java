import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-12
 * Time:10:48
 */
public class BinaryLookup {
    public static void main(String[] args) {
        //需要进行二分查找的数组
        int[] array = {2, 3, 4, 5, 6, 7, 8, 21, 34, 65, 78};
        //输入需要查找的数字
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        //subscript接收二分查找的结果 -1：没找到 其他：该数字下标
        int subscript = binaryLookup(array, k);
        //判断是否有该数字
        if(subscript == -1){
            System.out.println("没有找到数值为" + k + "的数在array数组内");
        }else{
            System.out.println("找到了，该下标为：" + subscript);
        }
    }

    public static int binaryLookup(int[] array, int k){
        //给定一个有序整型数组, 实现二分查找
        for (int i = 0; i < array.length; i++) {
            //找到了
            if(array[i] == k){
                return i;
            }
        }
        //没找到
        return -1;
    }
}
