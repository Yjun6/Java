/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-04
 * Time:23:05
 */
public class printfrequency {
    public static void main(String[] args) {
        //编写程序数一下 1到 100 的所有整数中出现多少个数字9
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            int j = i;
            while(j >= 9){
                if(j % 10 == 9){
                    sum++;
                }
                j /= 10;
            }
        }

        System.out.println("1-100中9出现的次数为：" + sum);
    }
}
