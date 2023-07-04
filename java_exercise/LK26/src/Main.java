/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-03
 * Time:21:17
 */
public class Main {
    public static void main(String[] args) {
        int[] tmp = {2,2,2,3,4};
        int ret = removeDuplicates(tmp);
        for (int i = 0; i < ret; i++) {
            System.out.print(tmp[i]+" ");
        }
    }
    public static int removeDuplicates(int[] nums) {
        int i=0;
        int j=1;
        int len = nums.length;
        while(j < len){
            while(j < len && nums[i] == nums[j]){
                j++;
            }
            if(j < len){
                nums[i+1] = nums[j];
                i++;
                j++;
            }
        }
        return i+1;
    }
}
