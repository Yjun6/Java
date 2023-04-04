/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
//题解
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int len = nums.length;
        reverse(nums,0,len-k-1);
        reverse(nums,len-k,len-1);
        reverse(nums, 0, len-1);
    }
    void reverse(int[] arr, int index, int s){
        int left = index;
        int right = s;
        while(left < right){
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}