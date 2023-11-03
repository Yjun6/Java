import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            // int a = in.nextInt();
            // int b = in.nextInt();
            // System.out.println(a + b);
            String ss1 = in.nextLine();
            String ss2 = in.nextLine();
            int max = 0;
            ss1 = " " + ss1;
            ss2 = " " + ss2;
            char[] s1 = ss1.toCharArray();
            char[] s2 = ss2.toCharArray();
            int len1 = s1.length;
            int len2 = s2.length;
            int[][] dp = new int[len1][len2];
            for (int i = 1; i < len1; i++) {
                for (int j = 1; j < len2; j++) {
                    if (s1[i] == s2[j]) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                        max = Math.max(dp[i][j], max);
                    }
                }
            }
            System.out.print(max);
        }
    }
}