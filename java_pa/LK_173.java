class Solution {
    public int takeAttendance(int[] records) {
        int left = 0;
        int right = records.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid == records[mid]) {
                left = mid + 1; 
            } else {
                right = mid;
            }
        }
        return (records[right] == right) ? right + 1 : right;
    }
}