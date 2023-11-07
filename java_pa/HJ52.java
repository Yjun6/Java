/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-07
 * Time:23:12
 */
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ52 {

    public static class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            while (in.hasNextLine()) { // 注意 while 处理多个 case
                // int a = in.nextInt();
                // int b = in.nextInt();
                // System.out.println(a + b);
                String ss1 = in.nextLine();
                char[] s1 = ss1.toCharArray();
                String ss2 = in.nextLine();
                char[] s2 = ss2.toCharArray();
                int len1 = ss1.length();
                int len2 = ss2.length();
                int[][] dp = new int[len1 + 1][len2 + 1];
                for (int i = 0; i < len1 + 1; i++) {
                    dp[i][0] = i;
                }
                for (int i = 0; i < len2 + 1; i++) {
                    dp[0][i] = i;
                }
                for (int i = 1; i < len1 + 1; i++) {
                    for (int j = 1; j < len2 + 1; j++) {
                        dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                        dp[i][j] = Math.min(dp[i][j], s1[i-1] == s2[j-1]?dp[i-1][j-1]:dp[i-1][j-1]+1);
                    }
                }
                System.out.print(dp[len1][len2]);
            }
        }
    }
}
