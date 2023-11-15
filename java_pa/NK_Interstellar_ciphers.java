import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] num = new int[10001];
        num[1] = 1;
        num[2] = 2;
        for (int i = 3; i < 10001; i++) {
            num[i] = num[i-1] + num[i-2];
            num[i] %= 10000;
        }
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            // int a = in.nextInt();
            // int b = in.nextInt();
            // System.out.println(a + b);
            int n = in.nextInt();
            StringBuilder ret = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int r = in.nextInt();
                if (num[r] < 10) {
                    ret.append("000");
                } else if (num[r] < 100) {
                    ret.append("00");
                } else if (num[r] < 1000) {
                    ret.append("0");
                }
                ret.append(num[r]);
            }
            System.out.println(ret);
        }
    }
}