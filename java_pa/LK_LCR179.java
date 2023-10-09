/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-10-09
 * Time:13:01
 */
public class LK_LCR179 {
    class Solution {
        public int[] twoSum(int[] price, int target) {
            int len = price.length;
            int[] pa = new int[2];
            int left = 0;
            int right = len - 1;
            while (left < right) {
                if(price[left] + price[right] > target) {
                    right--;
                } else if(price[left] + price[right] < target) {
                    left++;
                } else {
                    pa[0] = price[left];
                    pa[1] = price[right];
                    return pa;
                }
            }
            return pa;
        }
    }
}
