import java.util.*;


class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param x int整型 
     * @return int整型
     */
    public int sqrt (int x) {
        // write code here
        if(x <= 0){
            return 0;
        }
        int i;
        for( i=1; i <= x;i++){
            if(i*i <= x && (i+1)*(i+1) > x){
                break;
            }
        }

        return i;
    }
}