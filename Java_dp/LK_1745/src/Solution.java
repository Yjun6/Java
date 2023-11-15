/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-15
 * Time:21:36
 */
class Solution {
    public boolean checkPartitioning(String ss) {
        char[] s = ss.toCharArray();
        int len = s.length;
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (s[i] == s[j]) {
                    if (i + 1 == j) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
            }
        }
        for (int i = 1; i < len - 1; i++) {
            for (int j = i; j < len - 1; j++) {
                if (dp[i][j] && dp[0][i-1] && dp[j+1][len-1]) {
                    return true;
                }
            }
        }
        return false;
    }
}