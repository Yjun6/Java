/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    public static void main(String[] args) {
        //实现一个方法 avg, 以数组为参数, 求数组中所有元素的平均值(注意方法的返回值类型
        int[] arr = {2, 4, 5, 76, 3, 24};
        System.out.println( aver(arr) );
    }

    public static double aver(int[] arr){
        int ret = 0;
        for (int x:arr) {
            ret += x;
        }
        return ret * 1.0 / arr.length;
    }

}