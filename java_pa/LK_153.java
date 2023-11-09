class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int tagert = nums[right];
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] > tagert) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[right];
    }
}