class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = prices[0]*(-1);
        for(int i=1;i<n;i++){
            f[i] = Math.max(g[i-1]-prices[i],f[i-1]);
            g[i] = Math.max(g[i-1],f[i-1]+prices[i]-fee);
        }
        return Math.max(g[n-1],f[n-1]);
    }
}