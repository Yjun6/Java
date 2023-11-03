/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-03
 * Time:9:54
 */

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
            ss1 = " " + ss1;
            String ss2 = in.nextLine();
            ss2 = " " + ss2;
            if (ss1.length() > ss2.length()) {
                String tmp = ss1;
                ss1 = ss2;
                ss2 = tmp;
            }
            int len1 = ss1.length();
            int len2 = ss2.length();
            char[] s1 = ss1.toCharArray();
            char[] s2 = ss2.toCharArray();
            int max = 0;
            int index = 0;
            int[][] dp = new int[len1][len2];
            for (int i = 1; i < len1; i++) {
                for (int j = 1; j < len2; j++) {
                    if (s1[i] == s2[j]) {
                        dp[i][j] = dp[i-1][j-1] +1;
                        if (max < dp[i][j]) {
                            max = dp[i][j];
                            index = i;
                        }
                    }
                }
            }
            for (int i = index - max + 1; i <= index; i++) {
                System.out.print(s1[i]);
            }
        }
    }
}