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
            String t1 = in.nextLine();
            String t2 = in.nextLine();
            t1 = " " + t1;
            t2 = " " + t2;
            char[] s1 = t1.toCharArray();
            char[] s2 = t2.toCharArray();
            int len1 = s1.length;
            int len2 = s2.length;
            boolean[][] dp = new boolean[len1][len2];
            for (int i = 1; i < len1; i++) {
                if (s1[i] == '*') dp[i][0] = true;
                else break;
            }
            dp[0][0] = true;
            for (int i = 1; i < len1; i++) {
                for (int j = 1; j < len2; j++) {
                    if (s1[i] == '?' && func(s2[j])) {
                        dp[i][j] = dp[i-1][j-1];
                    } else if (s1[i] == '*' && func(s2[j])) {
                        dp[i][j] = dp[i][j-1] || dp[i-1][j] || dp[i-1][j-1];
                    } else {
                        dp[i][j] = (String.valueOf(s1[i]).equalsIgnoreCase(String.valueOf(s2[j])))
                                && dp[i-1][j-1];
                    }
                }
            }
            System.out.print(dp[len1-1][len2-1]);
        }
    }
    public static boolean func(char tmp) {
        return (tmp <= 'z' && tmp >= 'a') || (tmp <= 'Z' && tmp >= 'A') || (tmp <= '9' && tmp>= '0');
    }
}