/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-04
 * Time:11:43
 */
public class Main {
    public static void main(String[] args) {
        String ch = "MCMXCIV";
        System.out.println(romanToInt(ch));
    }
    public static int romanToInt(String s) {
        int num = 0;//保存所求整数
        int len = s.length();
        char tmp = ' ';
        for(int i=0; i < len ;i++){
            char ch = s.charAt(i);
            switch(ch){
                case 'I':
                    num += 1;
                    break;
                case 'V':
                    num += 5;
                    if(tmp == 'I'){
                        num -= 1*2;
                    }
                    break;
                case 'X':
                    num += 10;
                    if(tmp == 'I'){
                        num -= 1*2;
                    }
                    break;
                case 'L':
                    num += 50;
                    if(tmp == 'X'){
                        num -= 10*2;
                    }
                    break;
                case 'C':
                    num += 100;
                    if(tmp == 'X'){
                        num -= 10*2;
                    }
                    break;
                case 'D':
                    num += 500;
                    if(tmp == 'C'){
                        num -= 100*2;
                    }
                    break;
                case 'M':
                    num += 1000;
                    if(tmp == 'C'){
                        num -= 100*2;
                    }
                    break;
            }
            tmp = ch;
        }

        return num;
    }
}
