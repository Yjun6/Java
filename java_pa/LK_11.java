/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-09-24
 * Time:21:52
 */
public class LK_11 {
    public static int maxArea(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len-1;
        int max = 0;
        while(left <= right) {
            int ret = (height[right] < height[left] ? height[right] : height[left]) * (right-left);
            max = Math.max(max,ret);
            if(height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
}
