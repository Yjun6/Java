class Solution {
    public int minPathSum(int[][] grid) {
        //创建表
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        //初始化
        for(int i = 0;i<=n;i++){
            dp[0][i] = Integer.MAX_VALUE;
        }
        for(int i=0;i<=m;i++){
            dp[i][0] = Integer.MAX_VALUE;
        }
        dp[0][1] = 0;
        //填表
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j])+grid[i-1][j-1];
            }
        }
        //返回值
        return dp[m][n];
    }
}