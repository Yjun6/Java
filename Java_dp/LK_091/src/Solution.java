/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-14
 * Time:15:27
 */
public class Solution {
    public static void main(String[] args) {
        int[][] arr = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(minCost(arr));
    }

    public static int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n+1][3];
        for(int i=1;i<=n;i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+costs[i-1][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+costs[i-1][1];
            dp[i][2] = Math.min(dp[i-1][1],dp[i-1][0])+costs[i-1][2];
        }
        return Math.min(Math.min(dp[n][1],dp[n][2]),dp[n][0]);
    }
}