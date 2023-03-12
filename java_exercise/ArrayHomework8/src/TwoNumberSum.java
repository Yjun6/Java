import java.util.Arrays;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-12
 * Time:11:17
 */
public class TwoNumberSum {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，
     * 并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * */
    public static void main(String[] args) {
        int[] nums = {2, 5, 8, 14, 18};
        int target = 22;
        int[] ret = lookupSum(nums, target);
        if(ret[0] == -1){
            System.out.println("没有找到符合题目要求的两个值");
            return;
        }
        System.out.println( "找到了，" + Arrays.toString(ret) );
    }

    public static int[] lookupSum(int[] arr, int k){
        //i 保证每个值都被尝试相加
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] + arr[j] == k){
                    return new int[]{i, j};
                }
            }
        }
        //没找到k
        return new int[]{-1, -1};
    }
}
