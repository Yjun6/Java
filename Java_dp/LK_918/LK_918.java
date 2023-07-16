class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] f = new int[n+1];//大
        int[] g = new int[n+1];//小
        int sum = 0;//总和
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=1;i<=n;i++){
            f[i] = Math.max(f[i-1]+nums[i-1],nums[i-1]);
            g[i] = Math.min(g[i-1]+nums[i-1],nums[i-1]);
            max = Math.max(f[i],max);
            min = Math.min(min,g[i]);
            sum += nums[i-1];
        }
        return sum==min?max:Math.max(sum-min,max);
    }
}