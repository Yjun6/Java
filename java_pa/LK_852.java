class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (arr[mid - 1] < arr[mid]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}