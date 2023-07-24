class Solution {
    public int findLongestChain(int[][] pairs) {
        //先将数组排序
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);

        int n = pairs.length;
        int[] dp = new int[n];
        int ret = 1;
        for(int i=0;i<n;i++){
            dp[i] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                if(pairs[j][1] < pairs[i][0] && i!=j){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            ret = Math.max(ret,dp[i]);
        }
        return ret;
    }
}