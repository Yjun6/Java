import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            // int a = in.nextInt();
            // int b = in.nextInt();
            // System.out.println(a + b);
            int n = in.nextInt();
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = in.nextInt();
            }
            Arrays.sort(num);
            int count = func(num, n, 0, 0, 1);
            System.out.print(count);
        }
    }
    public static int func(int[] num, int n, int start, int sum, int mul) {
        int count = 0;
        for (int i = start; i < n; i++) {
            sum += num[i];
            mul *= num[i];
            if (sum > mul) {
                //符合要求
                count += 1 + func(num, n, i + 1, sum, mul);
            } else if (num[i] == 1) {
                count += func(num, n, i + 1, sum, mul);
            } else {
                break;
            }
            sum -= num[i];
            mul /= num[i];
            //去掉重复的
            while (i < n-1 && num[i] == num[i + 1]) i++;
        }
        return count;
    }
}