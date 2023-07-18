/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-18
 * Time:17:59
 */
class Solution {
    public static void main(String[] args) {
        int[] arr = {3,-1,4};
        System.out.println(maxProduct(arr));
    }
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int[] f = new int[n+1];//正
        int[] g = new int[n+1];//负
        f[0] = 1;
        g[0] = 1;
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            f[i] = Math.max(nums[i-1],Math.max(f[i-1]*nums[i-1],g[i-1]*nums[i-1]));
            g[i] = Math.min(nums[i-1],Math.min(g[i-1]*nums[i-1],f[i-1]*nums[i-1]));
            max = Math.max(max,f[i]);
        }
        return max;
    }
}
