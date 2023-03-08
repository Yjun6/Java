/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    public static void main(String[] args) {
        //实现一个方法 sum, 以数组为参数, 求数组所有元素之和.
        int[] arr = {2, 4, 5, 76, 3, 24};
        System.out.println( sum(arr) );
    }

    public static int sum(int[] arr){
        int ret = 0;
        for (int x:arr) {
            ret += x;
        }
        return ret;
    }

}