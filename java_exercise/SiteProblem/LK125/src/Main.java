/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
//题解
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            while(left<right && !isA(s.charAt(left))){
                left++;
            }
            while(left<right && !isA(s.charAt(right))){
                right--;
            }
            if(left<right && s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean isA(char ch){
        if(ch <= 'z'&&ch >='a')
            return true;
        if(ch <= '9'&& ch >= '0')
            return true;
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}