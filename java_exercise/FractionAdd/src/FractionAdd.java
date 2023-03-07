/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-07
 * Time:21:20
 */
public class FractionAdd {
    public static void main(String[] args) {
        System.out.println(sum(100));
    }

    public static double sum(int num){
        //计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
        double sum = 0;
        int flag = -1;
        while(num > 0){
            sum += flag * 1.0 / num;
            num--;
            flag *= -1;
        }

        return sum;
    }
}
