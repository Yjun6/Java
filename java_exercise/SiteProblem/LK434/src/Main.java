/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    //题解
    class Solution {
        public int countSegments(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }
            String[] arr = s.split(" ");
            int num = arr.length;
            for(int i = 0;i<arr.length;i++){
                if(arr[i].equals(""))
                    num--;
            }
            return num;
        }
    }

}