/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-10-14
 * Time:15:15
 */
public class LK_1004 {
    class Solution {
        public int longestOnes(int[] nums, int k) {
            int len = nums.length;
            int right = 0;
            int left = 0;
            int n = 0;
            int Max = 0;
            while(right < len) {
                if(nums[right] == 1) {
                    right++;
                } else if(n < k){
                    n++;
                    right++;
                }else if(n == k && nums[right] == 0) {
                    if(nums[left] == 0) {
                        n--;
                    }
                    left++;
                }
                Max = Math.max(Max, right-left);
            }
            return Max;
        }
    }
}
