class Solution {
    public int longestArithSeqLength(int[] nums) {
        int len = nums.length;
        int ret = 2;
        Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
        hash.put(nums[0],0);
        int[][] dp = new int[len][len];
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                dp[i][j] = 2;
            }
        }
        //固定倒数第二个数
        //查找最后一个数
        for(int i=1; i<len; i++) {
            for(int j=i+1; j<len; j++) {
                int tmp = 2*nums[i] - nums[j];
                if(hash.containsKey(tmp)) {
                    dp[i][j] = dp[hash.get(tmp)][i] + 1;
                }
                ret = Math.max(ret,dp[i][j]);
            }
            hash.put(nums[i],i);
        }
        return ret;
    }
}