class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //处理细节
        int len = cost.length;
        if(len == 0 || len == 1){
            return 0;
        }
        //创建dp表
        int[] dp = new int[len+1];
        //初始化
        dp[0] = dp[1] = 0;
        //填表
        for(int i=2; i <= len; i++){
            dp[i] = min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        //返回值
        return dp[len];
    }

     public int min(int tmp1, int tmp2){
         return tmp1>tmp2?tmp2:tmp1;
     }
}