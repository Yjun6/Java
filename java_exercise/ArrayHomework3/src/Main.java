/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    public static void main(String[] args) {
        //实现一个方法 transform, 以数组为参数, 循环将数组中的每个元素 乘以 2 , 并设置到对应的数组元素上.
        // 例如 原数组为 {1, 2, 3}, 修改之后为 {2, 4, 6}
        int[] arr = {3, 12, 5, 65, 0};

        System.out.println("数组值改变前：");
        for (int x:arr) {
            System.out.print(x + "  ");
        }
        System.out.println();

        transform(arr);

        System.out.println("数组值改变后：");
        for (int x:arr) {
            System.out.print(x + "  ");
        }
        System.out.println();
    }

    public static void transform(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
    }
}