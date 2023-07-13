class Solution {
    public int maxValue(int[][] grid) {
        //创建表
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        //初始化
        //填表
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];
            }
        }
        //返回值
        return dp[m][n];
    }
}