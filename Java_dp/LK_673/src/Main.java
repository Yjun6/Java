/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-23
 * Time:19:54
 */
class Solution {
    public static void main(String[] args) {
        int[] arr = {2,2,2};
        System.out.println(findNumberOfLIS(arr));
    }
    public static int findNumberOfLIS(int[] nums) {
        //1.创建dp表
        int n = nums.length;
        int[] len = new int[n];//长度
        int[] count = new int[n];//个数
        int maxCount = 1;
        int maxLen = 1;
        //2.初始化
        len[0] = count[0] = 1;
        //3.填表
        for(int i=1;i<n;i++){
            len[i] = 1;
            count[i] = 1;
            for(int j=0;j<i;j++){
                //求 len
                if(nums[i] > nums[j]){
                    if(len[j]+1 == len[i]){
                        count[i] += count[j];
                    }else if(len[j]+1 > len[i]){
                        count[i] = count[j];
                        len[i] = len[j]+1;
                    }
                }
            }
            if(len[i] == maxLen){
                maxCount += count[i];
            }else if(len[i] > maxLen){
                maxCount = count[i];
                maxLen = len[i];
            }
        }
        return maxCount;
    }
}