/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-08
 * Time:22:15
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(numDecodings("2106"));
    }
    public static int numDecodings(String s) {
        if(s.charAt(0) == '0'){
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 1;
        for(int i=1;i<len;i++){
            boolean ret = true;
            if(s.charAt(i) != '0'){
                dp[i] += dp[i-1];
                ret = false;
            }
            int tmp=Integer.parseInt(s.substring(i-1,i+1));
            if(tmp<=26 && tmp>=10){
                ret = false;
                if(i>1){
                    dp[i] += dp[i-2];
                }else{
                    dp[i] += 1;
                }
            }

            if(ret){
                return 0;
            }
        }
        return dp[len-1];
    }
}
