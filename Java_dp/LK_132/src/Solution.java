/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-16
 * Time:23:15
 */
class Solution {
    public int minCut(String ss) {
        // 1.先求出所有i位置结尾的回文子串那个值
        int len = ss.length();
        char[] s = ss.toCharArray();
        boolean[][] isP = new boolean[len][len];
        for (int i = len-1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    isP[i][j] = true;
                } else if (s[i] == s[j]) {
                    if (i+1 == j) {
                        isP[i][j] = true;
                    } else {
                        isP[i][j] = isP[i+1][j-1];
                    }
                }
            }
        }
        //2.计算最少分割次数
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < len; i++) {
            if (isP[0][i]) {
                dp[i] = 0;
            } else {
                for (int j = 1; j <= i; j++) {
                    if (isP[j][i]) {
                        dp[i] = Math.min(dp[j-1] +1, dp[i]);
                    }
                }
            }
        }
        return dp[len-1];
    }
}
