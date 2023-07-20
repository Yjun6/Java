class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {     
        //1.
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        Set<String> word = new HashSet<>();
        for(String x:wordDict){
            word.add(x);
        }
        //2.
        dp[0] = true;
        //3.
        for(int i=1;i<=n;i++){
            for(int j=i;j>=1;j--){
                //如果存在
                if(word.contains(s.substring(j-1,i+1-1)) && dp[j-1]){
                    dp[i] = true;
                    break;
                }
            }
        }
        //4.
        return dp[n];

    }
}