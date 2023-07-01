import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str string字符串 待判断的字符串
     * @return bool布尔型
     */
    public boolean judge (String str) {
        // write code here
        int len = str.length();
        int f=0,l=len-1;//快慢指针 f从前往后 l从后往前
        while(f < l){
            char s1 = str.charAt(f);
            char s2 = str.charAt(l);
            if(s1 != s2){
                return false;
            }
            f++;
            l--;
        }

        return true;
    }
}



