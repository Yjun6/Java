class Solution {
    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            long tmp = (long)(mid * mid);
            if (tmp < (long) x) {
                left = mid;
            } else if (tmp == (long) x) {
                return mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}