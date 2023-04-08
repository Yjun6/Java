/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
//题解
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0){
            return;
        }
        if(m == 0){
            for(int i = 0; i < n; i++){
                nums1[i] = nums2[i];
            }
            return;
        }

        int[] arr = new int[m+n];
        int p1 = 0;
        int p2 = 0;
        int i = 0;
        while(p1 < m && p2 < n){
            if(nums1[p1]<nums2[p2]){
                arr[i] = nums1[p1];
                p1++;
            }else{
                arr[i] = nums2[p2];
                p2++;
            }
            i++;
        }
        while(p1 < m){
            arr[i] = nums1[p1];
            i++;
            p1++;
        }
        while(p2 < n){
            arr[i] = nums2[p2];
            i++;
            p2++;
        }
        System.arraycopy(arr,0,nums1,0,m+n);
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}