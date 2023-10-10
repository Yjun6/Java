import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LK_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null) return list;
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len-2; i++) {
            if (nums[i] > 0) break;//小优化
            int left = i+1;
            int right = len-1;
            while(left < right) {
                if(nums[i]+nums[left]+nums[right] == 0) {
                    List<Integer> listTmp = new ArrayList<>();
                    listTmp.add(nums[i]);
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
                } else if (nums[i]+nums[left]+nums[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
            int iTmp = i;
            if(nums[i] == nums[iTmp]){
                while(i < len-2 && nums[i] == nums[iTmp]) {
                    i++;
                }
                i--;
            }
        }
        return list;
    }
}