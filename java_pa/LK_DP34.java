import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            // int a = in.nextInt();
            // int b = in.nextInt();
            // System.out.println(a + b);
            int n = in.nextInt();
            int q = in.nextInt();
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = in.nextInt();
            }
            long[] dp = new long[n + 1];
            for (int i = 1; i < n + 1; i++) {
                dp[i] = dp[i-1] + num[i-1];
            }
            while (q-- > 0) {
                int l = in.nextInt();
                int r = in.nextInt();
                long ret = dp[r] - dp[l-1];
                System.out.println(ret);
            }
        }
    }
}