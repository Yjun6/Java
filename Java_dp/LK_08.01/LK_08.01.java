class Solution {
    public int waysToStep(int n) {
        //处理细节
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }else if(n == 3){
            return 4;
        }

        int MD = 1000000007;
        //1.创建dp表
        int[] dp = new int[n+1];
        //2.初始化
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        //3.填表
        for(int i=4;i<=n;i++){
            dp[i] = ((dp[i-1]+dp[i-2])%MD+dp[i-3])%MD;
        }
        //4.返回值
        return dp[n];
    }
}