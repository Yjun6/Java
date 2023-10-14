/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-10-14
 * Time:15:54
 */
public class LK_1658 {
    public static void main(String[] args) {
        System.out.println(new LK_1658().new Solution().minOperations(new int[]{5}, 5));
    }
    class Solution {
        public int minOperations(int[] nums, int x) {
            int sum = 0;
            int len = nums.length;
            for(int i=0; i<len; i++) {
                sum += nums[i];
            }
            int num = 0;
            int Len = -1;
            for(int left=0, right=0; right<len; right++) {
                //进窗口
                num += nums[right];
                //判断
                while(left < len && num > sum-x) {
                    num -= nums[left++];
                }
                if(num == sum-x) {
                    Len = Math.max(Len, right-left+1);
                }
            }
            if(Len == -1) return -1;
            return len-Len;
        }
    }
}
