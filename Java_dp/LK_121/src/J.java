/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-15
 * Time:21:12
 */
class Solution {
    public static void main(String[] args) {
        int[] arr = {7,1,5,1,6,4};
        System.out.println(maxProfit(arr));
    }
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int ret = 0;
        for(int i=1;i<n;i++){
            ret = Math.max(prices[i]-min,ret);
            min = Math.min(min,prices[i]);
        }
        ret = Math.max(0,ret);
        return ret;
    }
}
