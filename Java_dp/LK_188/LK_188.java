class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        k = Math.min(k,n/2);
        int[][] f = new int[n][k+1];
        int[][] g = new int[n][k+1];
        for(int i=0;i<=k;i++){
            f[0][i] = -0x3f3f3f3f;
            g[0][i] = -0x3f3f3f3f;
        }
        f[0][0] = -prices[0];
        g[0][0] = 0;
        int max = Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            for(int j=0;j<=k;j++){
                f[i][j] = Math.max(f[i-1][j],g[i-1][j]-prices[i]);
                if(j-1>=0){
                    g[i][j] = Math.max(f[i-1][j-1]+prices[i],g[i-1][j]);
                }else{
                    g[i][j] = g[i-1][j];
                }
            }
        }
        for(int i=0;i<=k;i++){
            max = Math.max(max,g[n-1][i]);
        }
        return max;
    }
}