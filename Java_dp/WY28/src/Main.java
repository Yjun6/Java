import java.util.*;

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
            int m = in.nextInt();
            int[] dp = new int[m + 1];
            for (int i = 0; i < m + 1; i++) {
                dp[i] = Integer.MAX_VALUE;
            }
            dp[n] = 0;
            for (int i = n; i < m + 1; i++) {
                if (dp[i] == Integer.MAX_VALUE) {
                    //这个数字不在参考范围
                    dp[i] = -1;
                    continue;
                }
                List<Integer> list = func(i);
                for (int r : list) {
                    if (r + i <= m) {
                        if (dp[r + i] == Integer.MAX_VALUE) {
                            //第一次遍历这个数字
                            dp[r + i] = dp[i] + 1;
                        } else {
                            dp[r + i] = Math.min(dp[i] + 1, dp[r + i]);
                        }
                    }
                }
            }
            System.out.print(dp[m]);
        }
    }
    public static List<Integer> func(int tmp) {
        List<Integer> list = new ArrayList<Integer>();
        //返回tmp的所有约数
        for (int i = 2; i * i <= tmp; i++) {
            if (tmp % i == 0) {
                list.add(i);
                int j = tmp / i;
                if (j != i) {
                    list.add(j);
                }
            }
        }
        return list;
    }
}