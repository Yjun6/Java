import java.util.*;
import java.math.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextBigDecimal()) { // 注意 while 处理多个 case
            // int a = in.nextInt();
            // int b = in.nextInt();
            // System.out.println(a + b);
            BigDecimal a = in.nextBigDecimal();
            BigDecimal b = in.nextBigDecimal();
            BigDecimal c = in.nextBigDecimal();
            if (a.add(b).compareTo(c) == 1 
            && a.add(c).compareTo(b) == 1 
            && c.add(b).compareTo(a) == 1 )
            System.out.println("Yes");
            else
            System.out.println("No");
        } 
    }
}