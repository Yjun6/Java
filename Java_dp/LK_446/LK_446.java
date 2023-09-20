class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        Map<Long,List<Integer>> hash = new HashMap<>();
        for(int i=0; i<len; i++) {
            long n = (long)nums[i];
            if(!hash.containsKey(n)) {
                hash.put(n,new ArrayList<Integer>());
            }
            hash.get(n).add(i);
        }
        int ret = 0;
        for(int i=1; i<len; i++) {
            for(int j=i+1; j<len; j++) {
                long tmp = 2L*nums[i] - nums[j];
                if(hash.containsKey(tmp)) {
                    for(int k: hash.get(tmp)) {
                        if(k < i) {
                            dp[i][j] += dp[k][i] + 1;
                        } else {
                            break;
                        }
                    }               
                }
                ret += dp[i][j];
            }
        }
        return ret;
    }
}