/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-11
 * Time:15:05
 */
class Solution {
    public static void main(String[] args) {
        int[][] arr = {{1,0}};
        System.out.println(uniquePathsWithObstacles(arr));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //创建表
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];
        //初始化
        dp[0][1] = 1;
        //填表
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] += dp[i-1][j] + dp[i][j-1];
                if(obstacleGrid[i-1][j-1] == 1){
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m][n];
    }
}
