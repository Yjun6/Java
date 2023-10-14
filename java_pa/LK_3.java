import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-10-14
 * Time:14:41
 */
public class LK_3 {
    public static void main(String[] args) {
        System.out.println(new LK_3().lengthOfLongestSubstring("abba"));
    }
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hash = new HashMap<>();
        int len = s.length();
        int Max = 0;
        for(int i=0, j=0; j<len; j++) {
            char ch = s.charAt(j);
            if(hash.containsKey(ch)){
                while(hash.containsKey(ch)) {
                    hash.remove(s.charAt(i));
                    i++;
                }
            }
            hash.put(ch,j);
            Max = Math.max(Max, j-i+1);
        }
        return Max;
    }
}