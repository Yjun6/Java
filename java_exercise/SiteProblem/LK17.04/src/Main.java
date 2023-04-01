/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

//题解
class Solution {
    public int missingNumber(int[] nums) {
        int[] num = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            num[nums[i]]++;
        }
        for(int i = 0; i < num.length; i++){
            if(num[i] == 0){
                return i;
            }
        }
        return -1;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}