class Solution {
    public int minCostClimbingStairs(int[] cost) {
      //处理细节
        int len = cost.length;
        if(len == 0 || len == 1){
            return 0;
        }
        //创建dp表
        int[] dp = new int[len];
        //初始化
        dp[len-1] = cost[len-1];
        dp[len-2] = cost[len-2];
        //填表
        for(int i=len-3; i >= 0; i--){
            dp[i] = cost[i]+(dp[i+1]<dp[i+2]?dp[i+1]:dp[i+2]);
        }
        //返回值
        return dp[0]<dp[1]?dp[0]:dp[1];
    }

}