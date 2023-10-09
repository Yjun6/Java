import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-10-09
 * Time:12:47
 */
public class LK_611 {
    public static void main(String[] args) {
        LK_611 l = new LK_611();
        int[] arr = {2,2,3,4};
        System.out.println(l.triangleNumber(arr));
    }
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        if (n <= 2) return 0;
        int ret = 0;
        Arrays.sort(nums);
        for (int i = n-1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if(nums[left] + nums[right] > nums[i]) {
                    ret += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ret;
    }
}