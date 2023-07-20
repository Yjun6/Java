/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-20
 * Time:19:30
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(findSubstringInWraproundString("zab"));
    }
    public static int findSubstringInWraproundString(String s) {
        //创建dp表
        char[] ss = s.toCharArray();
        int n = ss.length;
        int[] dp = new int[n];
        int sum = 0;
        //初始化
        dp[0] = 1;
        //填表
        //这里的循环对应的是dp的下标
        for(int i=1;i<n;i++){
            dp[i] = 1;
            if(ss[i-1]+1==ss[i] || (ss[i-1]=='z'&&ss[i]=='a')){
                dp[i] += dp[i-1];
            }
        }
        //去重
        int[] arr = new int[26];
        for(int i=0;i<n;i++){
            int j = ss[i]-'a';//每个字符对应的下标
            arr[j] = Math.max(arr[j],dp[i]);
        }
        //返回值
        for(int i=0;i<26;i++){
            sum += arr[i];
        }
        return sum;
    }
}