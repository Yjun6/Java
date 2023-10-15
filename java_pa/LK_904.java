import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-10-15
 * Time:11:37
 */
public class LK_904 {
    public static void main(String[] args) {
        System.out.println(new LK_904().new Solution().totalFruit(new int[]{1, 2, 1}));
    }
    class Solution {
        public int totalFruit(int[] fruits) {
            int n = fruits.length;
            int[] num = new int[n];
            int size = 0;
            int MaxLen = 0;
            for (int left = 0, right = 0; right < n; right++) {
                //进窗口
                num[fruits[right]]++;
                //判断
                if (num[fruits[right]] == 1) {
                    size++;
                }
                while (size > 2) {
                    //出窗口
                    num[fruits[left]]--;
                    if(num[fruits[left++]] == 0) {
                        size--;
                        break;
                    }
                }
                MaxLen = Math.max(MaxLen, right - left + 1);
            }
            return MaxLen;
        }
    }
}
