/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-12
 * Time:11:37
 */
public class FindNumber {
    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 5, 4, 7, 6, 8, 7, 3, 4, 8, 0};
        //k 接收只出现一次的数值的下标  没有：-1 有：下标（ >= 0）
        int k = findNumber(arr);
        if(k == -1){
            System.out.println("arr数组中没有只出现一次的元素");
        }else{
            System.out.println("该数值为：" + arr[k]);
        }
    }

    public static int findNumber(int[] arr){
        //接收arr中数值出现的次数
        int[] ret = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            //每进入一次for循环，ret数组对应的值增加一次
            ret[i]++;
            for (int j = i + 1; j < arr.length; j++) {
                //找到了相同的两个数值
                if(arr[i] == arr[j]){
                    ret[i]++;
                    ret[j]++;
                    break;
                }
            }
            //该数值只出现过一次
            if(ret[i] == 1){
                return i;
            }
        }

        //没找到
        return -1;
    }
}
