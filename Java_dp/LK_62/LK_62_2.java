class Solution {
    public int uniquePaths(int m, int n) {
        //创建表
        int[][] dp = new int[m+1][n+1];
        //初始化
        dp[0][1] = 1;
        //填表
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        //返回值
        return dp[m][n];
    }
}