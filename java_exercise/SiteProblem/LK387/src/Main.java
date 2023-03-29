/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

//题解
class Solution {
    public int firstUniqChar(String s) {
        if(s == null||s.length()==0){
            return -1;
        }

        char[] ch = new char[s.length()];
        for(int i = 0;i<s.length();i++){
            ch[i] = s.charAt(i);
        }

        int[] num = new int[32];
        for(int i = 0; i < s.length();i++){
            (num[ch[i] - 97])++;
        }

        for(int i = 0; i < s.length();i++){
            if(num[ch[i] - 97] == 1){
                return i;
            }
        }

        return -1;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}