/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-07
 * Time:23:41
 */
public class AddOverload {
    public static void main(String[] args) {
        //在同一个类中,分别定义求两个整数的方法 和 三个小数之和的方法。
        System.out.println( add(23, 45) );
        System.out.println( add(12,34,56) );
    }

    public static int add(int a1, int a2){
        return a1 + a2;
    }

    public static int add(int a1, int a2, int a3){
        return a1 + a2 + a3;
    }
}
