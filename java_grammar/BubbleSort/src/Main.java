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
        int[] array = {1, 3, 2, 4, 5, 76, 3, 2, 4};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void bubbleSort(int[] array){
        if(array.length == 0){
            System.out.println("该数组内没有元素");
            return;
        }

        //从小到大排序
        //比较的轮次
        for (int i = 0; i < array.length - 1; i++) {
            //判断是否还需要排序
            boolean f = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j + 1]){
                    f = false;//还需要排序
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
            //已经全部排序完成
            if(f == true){
                break;
            }
        }
    }
}