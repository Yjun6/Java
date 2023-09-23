/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-09-23
 * Time:11:05
 */
class LK_1089 {
    public static void main(String[] args) {
        int[] arr = {1,0,2,3,0,4,5,0};
        duplicateZeros(arr);
    }
    public static void duplicateZeros(int[] arr) {
        int cur = 0, dest = 0;
        int len = arr.length;
        boolean ret = true;
        //1.寻找复写末尾数值
        while(dest < len) {
            if(arr[cur] != 0) {
                dest++;
            } else {
                //处理边界问题
                if(dest == len-1) {
                    ret = false;
                    dest--;
                }
                dest += 2;
            }
            cur++;
        }
        // 末尾下标+1
        int num = cur;
        //2.复写
        cur = num-1;
        dest = len-1;
        while(cur >= 0) {
            if(!ret) {
                ret = true;
            } else {
                if(arr[cur] == 0) {
                    arr[dest] = arr[cur];
                    dest--;
                }
            }
            arr[dest] = arr[cur];
            dest--;
            cur--;
        }
    }
}