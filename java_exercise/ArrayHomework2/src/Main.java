/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    public static void main(String[] args) {
        //实现一个方法 printArray, 以数组为参数, 循环访问数组中的每个元素, 打印每个元素
        int[] arr = {1, 3, 45, 4567, 34654, 2, 234};
        printArray(arr);
    }

    public static void printArray(int[] arr){
        for (int i:arr) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }
}