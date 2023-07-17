/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-17
 * Time:14:21
 */
class Solution {
    public static void main(String[] args) {
        int[] arr = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(arr));
    }
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n][3];
        int[][] g = new int[n][3];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<3;i++){
            g[0][i] = -0x3f3f3f3f;
            f[0][i] = -0x3f3f3f3f;
        }
        f[0][0] = -prices[0];
        g[0][0] = 0;
        for(int i=1;i<n;i++){
            for(int j=0;j<3;j++){
                if(j-1>=0){
                    g[i][j] = Math.max(g[i-1][j],f[i-1][j-1]+prices[i]);
                }else{
                    g[i][j] = g[i-1][j];
                }
                f[i][j] = Math.max(f[i-1][j],g[i-1][j]-prices[i]);
            }
        }
        for(int i=0;i<3;i++){
            max = Math.max(max,g[n-1][i]);
        }
        return max;
    }
}