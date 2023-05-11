import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String arr = scanner.nextLine();
        System.out.println(func(arr));
    }
    static int func(String s){
        String arr = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch < '0' || ch > '9'){
                return 0;
            }else{
                arr += ch;
            }
        }
        int ret = Integer.parseInt(arr);
        return ret;
    }
}