import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            // int a = in.nextInt();
            // int b = in.nextInt();
            // System.out.println(a + b);
            int n = in.nextInt();
            int m = in.nextInt();
            int[] dp = new int[m + 1];
            for (int i = 0; i < m + 1; i++) {
                dp[i] = Integer.MAX_VALUE;
            }
            dp[n] = 0;
            for (int i = n; i < m + 1; i++) {
                if (dp[i] == Integer.MAX_VALUE) {
                    //这个数字不在参考范围
                    dp[i] = -1;
                    continue;
                }
                List<Integer> list = func(i);
                for (int r : list) {
                    if (r + i <= m) {
                        if (dp[r + i] == Integer.MAX_VALUE) {
                            //第一次遍历这个数字
                            dp[r + i] = dp[i] + 1;
                        } else {
                            dp[r + i] = Math.min(dp[i] + 1, dp[r + i]);
                        }
                    }
                }
            }
            System.out.print(dp[m]);
        }
    }
    public static List<Integer> func(int tmp) {
        List<Integer> list = new ArrayList<Integer>();
        //返回tmp的所有约数
        for (int i = 2; i * i <= tmp; i++) {
            if (tmp % i == 0) {
                list.add(i);
                int j = tmp / i;
                if (j != i) {
                    list.add(j);
                }
            }
        }
        return list;
    }
}

// 注意类名必须为 Main, 不要有任何 package xxx 信息
class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            //     int a = in.nextInt();
            //     int b = in.nextInt();
            //     System.out.println(a + b);
            // }
            int T = in.nextInt();//表示有几组数据
            while (T-- > 0) {
                int n = in.nextInt();//有 2N组数
                int k = in.nextInt();//洗牌k次
                int[] num1 = new int[n];
                int[] num2 = new int[n];
                for (int i = 0; i < n; i++) {
                    num1[i] = in.nextInt();
                }
                for (int i = 0; i < n; i++) {
                    num2[i] = in.nextInt();
                }
                int[] ret = func(num1, num2);
                while (k-- > 1) {
                    for (int i = 0; i < n; i++) {
                        num1[i] = ret[i];
                    }
                    for (int i = n; i < 2 * n; i++) {
                        num2[i - n] = ret[i];
                    }
                    ret = func(num1, num2);
                }
                for (int i = 2 * n - 1; i >= 0; i--) {
                    System.out.print(ret[i] + " ");
                }
                System.out.println();
            }
        }
    }
    public static int[] func(int[] num1, int[] num2) {
        int len = num1.length;
        int[] tmp = new int[len * 2];
        for (int i = len * 2 - 1, j = 0; i > 0 && j < len; j++, i -= 2) {
            tmp[i] = num1[j];
            tmp[i - 1] = num2[j];
        }
        return tmp;
    }
}

class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            // int a = in.nextInt();
            // int b = in.nextInt();
            // System.out.println(a + b);
            int tmp = in.nextInt();
            String UD = in.next();
            char[] UDTmp = UD.toCharArray();
            int len = UD.length();
            int change = 1;//当前光标位置
            if (tmp <= 4) {
                //不需要翻页
                for (int i = 1; i <= tmp; i++) {
                    System.out.print(i);
                    if (i != tmp) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
                //光标挪动
                for (int i = 0; i < len; i++) {
                    if (UDTmp[i] == 'U') {
                        if (change == 1) {
                            change = tmp;
                        } else {
                            change--;
                        }
                    } else if (UDTmp[i] == 'D') {
                        if (change == tmp) {
                            change = 1;
                        } else {
                            change++;
                        }
                    }
                }
                System.out.print(change);
            } else {
                //需要翻页
                //判断这个数字是否对4取余
                boolean r = (tmp % 4) == 0;
                //光标挪动
                for (int i = 0; i < len; i++) {
                    if (UDTmp[i] == 'U') {
                        if (change == 1) {
                            change = tmp;
                        } else {
                            change--;
                        }
                    } else if (UDTmp[i] == 'D') {
                        if (change == tmp) {
                            change = 1;
                        } else {
                            change++;
                        }
                    }
                }
                //判断当前change是否在最后那一面 并且没有4
                if (!r && (tmp - (tmp % 4)) < change) {
                    for (int i = tmp - (tmp % 4) + 1; i <= tmp; i++) {
                        System.out.print(i);
                        if (i != tmp) {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                    System.out.print(change);
                } else {
                    int f = change / 4;
                    for (int i = f * 4 + 1; i <= f * 4; i++) {
                        System.out.print(i);
                        if (i != f * 2) {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                    System.out.print(change);
                }
            }
        }
    }
}
