/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-11
 * Time:22:57
 */
class Solution {
    public static void main(String[] args) {
        int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(arr));
    }
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][]dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = Integer.MAX_VALUE;
                }else{
                    dp[0][1] = 0;
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];
                }
            }

        }
        return dp[m][n];
    }
}