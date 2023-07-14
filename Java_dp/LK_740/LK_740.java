class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] num = new int[10001];
        for(int x:nums){
            num[x] += x;
        } 

        int[] f = new int[10001];
        int[] g = new int[10001];
        f[0] = num[0];
        for(int i=1; i<10001; i++){
            f[i] = g[i-1]+num[i];
            g[i] = Math.max(g[i-1],f[i-1]);
        }
        return Math.max(g[10000],f[10000]);
    }
}