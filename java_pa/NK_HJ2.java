import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            // int a = in.nextInt();
            // int b = in.nextInt();
            // System.out.println(a + b);
            String ss1 = in.nextLine();
            String ss2 = in.nextLine();
            char[] s1 = ss1.toCharArray();
            int len = s1.length;
            int count = 0;
            for (int i = 0; i < len; i++) {
                //忽略大小写
                if (ss2.equalsIgnoreCase(String.valueOf(s1[i]))) {
                    count++;
                }
            }
            System.out.print(count);
        }
    }
}