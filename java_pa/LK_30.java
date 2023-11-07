import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-10-28
 * Time:20:04
 */
public class LK_30 {
    public static void main(String[] args) {
        new LK_30().new Solution().findSubstring("barfoothefoobarman", new String[]{"foo","bar"});
    }
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> list = new ArrayList<>();
            int lenS = s.length();
            int lenW = words.length;
            int len = words[0].length();
            //1.将words全放入哈希表
            Map<String, Integer> hash = new HashMap<>();
            for (int i = 0; i < lenW; i++) {
                hash.put(words[i], hash.getOrDefault(words[i], 0) + 1);
            }
            //2.将s分成一段一段的
            for (int i = 0; i < len; i++) {
                Map<String, Integer> hash1 = new HashMap<>();
                for (int left = i, right = i, count = 0; right + len <= lenS; right += len) {
                    //进窗口
                    String tmp = s.substring(right, right + len);
                    hash1.put(tmp, hash1.getOrDefault(tmp, 0) + 1);
                    //维护
                    if (hash1.get(tmp) <= hash.getOrDefault(tmp, 0)) {
                        count++;
                    }
                    if (right - left + 1 > len * lenW) {
                        //出窗口
                        String tmp2 = s.substring(left, left + len);
                        //维护
                        if (hash1.get(tmp2) <= hash.getOrDefault(tmp2, 0)) {
                            count--;
                        }
                        hash1.put(tmp2, hash1.get(tmp2) - 1);
                        left += len;
                    }
                    //更新结果
                    if (count == lenW) {
                        list.add(left);
                    }
                }
            }
            return list;
        }
    }
    }

