/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5};
        String ret = mytoString(array);
        System.out.println(ret);
    }

    public static String mytoString(int[] array){
        //判断空指针
        if(array == null || array.length == 0){
            return "null";
        }

        String ret = "[";

        //数组转字符串
        for (int i = 0; i < array.length; i++) {
            if(i == array.length - 1){
                ret += array[i];
            }else{
                ret += array[i] + ", ";
            }
        }

        ret += "]";

        return ret;
    }
}