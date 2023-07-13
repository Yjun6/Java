class Solution {
    public int massage(int[] nums) {
        //
        int n = nums.length;
        if(n == 0) return 0;
        int[] f = new int[n];//选
        int[] g = new int[n];//不选
        //
        f[0] = nums[0];
        //
        for(int i=1;i<n;i++){
            g[i] = Math.max(f[i-1],g[i-1]);
            f[i] = g[i-1] + nums[i];
        }
        return Math.max(f[n-1],g[n-1]);
    }
}