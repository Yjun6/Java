/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-15
 * Time:21:01
 */
public class LK_5 {
    public static void main(String[] args) {
        System.out.println(new LK_5().new Solution().longestPalindrome("babad"));
    }
    class Solution {
        public String longestPalindrome(String ss) {
            char[] s = ss.toCharArray();
            int len = s.length;
            boolean[][] dp = new boolean[len][len];
            int index1 = 0, index2 = 0;
            for (int i = len-1; i >= 0; i--) {
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
                int left = i, right = len - 1;
                for (; right >= left; right--) {
                    if (dp[left][right]) break;
                }
                if (index2 - index1 < right - left) {
                    index2 = right;
                    index1 = left;
                }
            }
            return ss.substring(index1, index2 + 1);
        }
    }
}
