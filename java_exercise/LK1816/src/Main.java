/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-03
 * Time:20:45
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(truncateSentence("This is very easy? No.", 4));
    }

    public static String truncateSentence(String s, int k) {
        int i=0;
        char[] tmp = new char[s.length()];
        while(k > 0 && i < s.length()){
            Character ch = s.charAt(i);
            if(ch == '\0' || ch == ' '){
                k--;
            }
            //" " no char yes
            if(k <= 0 && ch == ' '){
                //什么也不加
            }else{
                tmp[i] = ch;
                i++;
            }
        }
        String tmp1=String.valueOf(tmp);
        return tmp1.substring(0,i);
    }
}
