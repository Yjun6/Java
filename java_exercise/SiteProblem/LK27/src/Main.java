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
    public int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        while(i < nums.length){
            if(nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
            i++;
        }
        return j;
    }
}
public class Main {

}