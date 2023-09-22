class Solution {
    public void moveZeroes(int[] nums) {
        //处理好了的区间 0区间 未处理区间
        int len = nums.length;
        for(int cur=0, dest=-1; cur<len; cur++) {
            if(nums[cur]!=0) {
                dest++;
                int tmp = nums[dest];
                nums[dest] = nums[cur];
                nums[cur] = tmp;
            }
        }
    }
}