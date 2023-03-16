/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-07
 * Time:23:45
 */
public class MaxOverload {
    public static void main(String[] args) {
        //在同一个类中定义多个方法：要求不仅可以求2个整数的最大值，还可以求3个小数的最大值
        System.out.println( max(5621,1245) );
        System.out.println( max(34.13, 134.32, 12.1) );
    }

    public static int max(int num1, int num2){
        return num1 > num2 ? num1 : num2;
    }

    public static double max(double num1, double num2, double num3){
        double num = num1 > num2 ? num1 : num2;
        return num > num3 ? num : num3;
    }
}
