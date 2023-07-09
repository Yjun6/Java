/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-09
 * Time:20:51
 */
public class LK91_2 {
    public int numDecodings(String s) {
        char[] ss = s.toCharArray();
        if(ss[0] == '0'){
            return 0;
        }
        //创建表
        int len = ss.length;
        int[] dp = new int[len];
        //初始化
        dp[0] = 1;
        //填表
        for(int i=1;i<len;i++){
            boolean ret = true;
            if(ss[i] != '0'){
                dp[i] += dp[i-1];
                ret = false;
            }
            // int tmp=Integer.parseInt(s.substring(i-1,i+1));
            int tmp = (ss[i-1]-'0')*10+ss[i]-'0';
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