import java.util.Arrays;

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
        int[] arr=new int[len];
        System.arraycopy(nums,0,arr,0,len);
        System.arraycopy(arr,len-k,nums,0,k);
        System.arraycopy(arr,0,nums,k,len-k);

    }
}
public class Main {

}