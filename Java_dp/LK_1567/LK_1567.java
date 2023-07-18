class Solution {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int[] f = new int[n+1];
        int[] g = new int[n+1];
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(nums[i-1]>0){
                f[i] = f[i-1]+1;
                g[i] = g[i-1]==0?0:g[i-1]+1;
            }else if(nums[i-1]<0){
                f[i]=g[i-1]==0?0:g[i-1]+1;
                g[i]=f[i-1]+1;
            }
            max = Math.max(max,f[i]);
        }
        return max;
    }
}