import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-10-15
 * Time:19:42
 */
public class LK_438 {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> list = new ArrayList<>();
            //26个小写字母 使用数组代替hash表
            int[] num = new int[26];
            //将p存储到哈希表中
            int lenP = p.length();
            for(int i = 0; i < lenP; i++) {
                char ch = p.charAt(i);
                num[ch - 'a']++;
            }
            //比较s字母在p存在的起始位置
            int lenS = s.length();
            char[] ch = s.toCharArray();
            int[] numS = new int[26];
            for(int left = 0, right = 0, count = 0; right < lenS; right++) {
                char chTmp = ch[right];
                //进窗口
                numS[chTmp - 'a']++;
                //维护
                if(numS[chTmp - 'a'] <= num[chTmp - 'a']) {
                    count++;
                }
                //判断
                if(right - left + 1 > lenP) {
                    //出窗口
                    if(numS[ch[left] - 'a'] <= num[ch[left] - 'a']) {
                        count--;
                    }
                    numS[ch[left] - 'a']--;
                    left++;
                }
                //更新结果
                if(count == lenP) {
                    list.add(left);
                }
            }
            return list;
        }
    }
}
