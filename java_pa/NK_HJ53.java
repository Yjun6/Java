import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            // int a = in.nextInt();
            // int b = in.nextInt();
            // System.out.println(a + b);
            //一道规律题，我哭死
            int n = in.nextInt();
            if (n <= 2) {
                System.out.print(-1);
                continue;
            }
            int[] num = {2, 3, 2, 4};
            n -= 3;
            n = num[n % 4];
            System.out.print(n);

            //这种写法内存溢出
            // int[][] num = new int[n][2 * n - 1];
            // //初始化
            // num[0][n - 1] = 1;
            // num[1][n -2] = num[1][n-1] = num[1][n] = 1;
            // int index = -1;
            // for (int i = 2; i < n; i++) {
            //     for (int j = n - 1 - i; j <= n - 1 + i; j++) {
            //         if (j == n - 1 - i || j == n - 1 + i) {
            //             num[i][j] = 1;
            //         } else if (j == n - i) {
            //             num[i][j] = num[i - 1][j] + num[i - 1][j + 1]; 
            //         } else if (j == n - 2 + i) {
            //             num[i][j] = num[i - 1][j - 1] + num[i - 1][j];
            //         } else {
            //             num[i][j] = num[i - 1][j - 1] + num[i - 1][j] + num[i - 1][j + 1]; 
            //         }
            //         if (i == n - 1 && num[i][j] % 2 == 0) {
            //             index = j + 1;
            //             break;
            //         }
            //     }
            // }
            // System.out.print(index);
        }
    }
}
