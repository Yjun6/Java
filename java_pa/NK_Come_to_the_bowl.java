import java.util.Scanner;
import java.math.BigDecimal;
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextBigDecimal()) { // 注意 while 处理多个 case
            // int a = in.nextInt();
            // int b = in.nextInt();
            // System.out.println(a + b);

            BigDecimal n = in.nextBigDecimal();
            BigDecimal r = in.nextBigDecimal();
            BigDecimal c = r.multiply(new BigDecimal(2));
            c = c.multiply(new BigDecimal(3.14));
            if (n.compareTo(c) == 1) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }
}