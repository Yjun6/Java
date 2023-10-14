/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-10-14
 * Time:13:11
 */
public class LK_209 {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int len = nums.length;
            int lenN = 0;
            int n = 0;
            int Min = Integer.MAX_VALUE;
            for (int i = 0, right = 0; i < len && right < len; right++) {
                n += nums[right];
                lenN++;
                while (i < len && n >= target) {
                    Min = Math.min(Min, lenN);
                    n -= nums[i];
                    i++;
                    lenN--;
                }
            }
            return Min == Integer.MAX_VALUE ? 0 : Min;
        }
    }
}