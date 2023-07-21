/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-21
 * Time:18:52
 */
public class LK_300 {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(arr));
    }
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for(int i=1;i<n;i++){
            dp[i] = 1;
            for(int j = i-1;j>=0;j--){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
