/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
//题解
class Solution {
    public String toLowerCase(String s) {
        if(s==null || s.length() == 0){
            return null;
        }
        char[] arr = new char[s.length()];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch <= 'Z' && ch >= 'A'){
                ch += 32;
            }
            arr[i] = ch;
        }
        return String.valueOf(arr);
    }
}
public class Main {
    public static void main(String[] args) {

    }
}