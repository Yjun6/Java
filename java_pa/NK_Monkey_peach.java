import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int x = 0;
        while ((x = in.nextInt())!= 0) { // 注意 while 处理多个 case
            if (x == 1) {
                System.out.println(1+" "+1);
            } else {
                System.out.println((long)(Math.pow(5,x)-4)+" "+(long)(Math.pow(4,x)-4+x));
            }
        }
    }
}