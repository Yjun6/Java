/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-08
 * Time:14:32
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(fib(2));
    }
    public static int fib(int n) {
        //细节处理
        if(n == 0 || n == 1){
            return n;
        }
        //创建表
        int[] dp = new int[n+1];
        //初始化
        dp[0] = 0;
        dp[1] = 1;
        //填表
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        //返回值
        return dp[n];
    }
}
