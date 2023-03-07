/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-07
 * Time:21:58
 */
public class SumMax {
    public static void main(String[] args) {
        //创建方法求两个数的最大值max2，随后再写一个求3个数的最大值的函数max3。
        //在max3这个函数中，调用max2函数，来实现3个数的最大值计算
        System.out.println( max2(34, 56) );
        System.out.println( max3(123, 34, 123) );
    }

    public static int max2(int num1, int num2){
        return (num1>num2)?num1:num2;
    }

    public static int max3(int num1, int num2, int num3){
        int tmp = max2(num1, num2);
        return max2(tmp, num3);
    }
}
