class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];//大于
        int[] g = new int[n];//小于
        f[0] = 1;
        g[0] = 1;
        int max = 1;
        for(int i=1;i<n;i++){
            f[i] = g[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]){
                    f[i] = Math.max(f[i],g[j]+1);
                }else if(nums[i] < nums[j]){
                    g[i] = Math.max(g[i],f[j]+1);
                }
            }
            max = Math.max(max,(Math.max(f[i],g[i])));
        }
        return max;
    }
}