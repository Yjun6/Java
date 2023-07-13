class Solution {
    public int minFallingPathSum(int[][] matrix) {
        //创建表
        int m = matrix.length;
        int[][] dp = new int[m+1][m+2];
        //初始化
        //填表
        for(int i = 1;i<m+1;i++){
            for(int j = 1;j<m+1;j++){
                if(j == 1){
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j+1])+matrix[i-1][j-1]; 
                }else if(j == m){
                    dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+matrix[i-1][j-1]; 
                }else{
                    dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i-1][j+1])+matrix[i-1][j-1]; 
                }                        
            }
        }
        //返回值
        int min = dp[m][1];
        for(int i=2;i<=m;i++){
            if(dp[m][i] < min){
                min = dp[m][i];
            }
        }
        return min;
    }
}