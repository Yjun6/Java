class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
        int len = arr.length;
        for(int i=0; i<len; i++) {
            hash.put(arr[i],i);
        }

        int[][] dp = new int[len][len];
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                dp[i][j] = 2;
            }
        }

        int max = 2;
        for(int i=2; i<len; i++) {
            for(int j=1; j<i; j++) {
                int tmp = arr[i] - arr[j];
                if(hash.containsKey(tmp)) {
                    if(tmp < arr[j]) {
                        dp[j][i] = dp[hash.get(tmp)][j] + 1;
                    }
                }
                max = Math.max(max,dp[j][i]);
            }
        }

        return max<3 ? 0 : max;
    }
}