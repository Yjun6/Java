import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-10-10
 * Time:21:14
 */
public class LK_18 {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2}, 0));
    }
        public static List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> list = new ArrayList<>();
            //1.排序
            Arrays.sort(nums);
            //2.固定值
            int len = nums.length;
            for(int i = 0; i < len; ) {
                // if(nums[i] > target && target > 0) break;
                for(int j = i+1; j < len; ) {
                    // if((long)(nums[i] + nums[j]) > (long)target && target > 0) break;
                    int left = j+1;
                    int right = len-1;
                    while(left < right) {
                        if((long)(nums[left]+nums[right])+(long)(nums[i]+nums[j]) == (long)target){
                            List<Integer> listTmp = new ArrayList<>();
                            listTmp.add(nums[i]);
                            listTmp.add(nums[j]);
                            listTmp.add(nums[left]);
                            listTmp.add(nums[right]);
                            list.add(listTmp);
                            int leftTmp = left;
                            int rightTmp = right;
                            while(left < right && nums[left] == nums[leftTmp]) {
                                left++;
                            }
                            while(left < right && nums[right] == nums[rightTmp]) {
                                right--;
                            }
                        } else if((long)(nums[left]+nums[right])+(long)(nums[i]+nums[j]) > (long)target){
                            right--;
                        } else {
                            left++;
                        }
                    }
                    j++;
                    while(j < len && nums[j-1] == nums[j]) {
                        j++;
                    }
                }
                i++;
                while(i < len && nums[i-1] == nums[i]) {
                    i++;
                }
            }
            return list;
        }
    }