import java.util.*;


public class NC112 {
    public String solve (int m, int n) {
        // write code here
        char[] tmp = new char[32];//存储对应的进制
        StringBuilder s = new StringBuilder();
        if(m < 0) {
            s.append("-");
            // System.out.print("-");
            m *= (-1);
        }
        int i = qu_N(n,m,tmp);
        for(int j = i-1; j >= 0; j--) {
            s.append(tmp[j]);
            // System.out.print(tmp[j]);
        }
        return s.toString();
    }
    private static int qu_N(int N,int m,char[] tmp) {
        int i = 0;
        while(m > 0) {
            int r1 = m % N;
            char r = func(r1);
            tmp[i] = r;
            i++;
            m = m / N;
        }
        return i;

    }
    private static char func(int r) {
        if(r < 10) {
            return (char)(r + '0');
        }
        switch(r) {
            case 10:
                return 'A';
            case 11:
                return 'B';
            case 12:
                return 'C';
            case 13:
                return 'D';
            case 14:
                return 'E';
            case 15:
                return 'F';
        }
        return '1';
    }
}

//题目 版本2
class Main12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int m = in.nextInt();//十进制数
//            System.out.println(m);
            int n = in.nextInt();//需要转换的进制数
            char[] tmp = new char[32];//存储对应的进制
            if(m < 0) {
                System.out.print("-");
                m *= (-1);
            }
            int i = qu_N(n,m,tmp);
            for(int j = i-1; j >= 0; j--) {
                System.out.print(tmp[j]);
            }

        }
    }
    public static int qu_N(int N,int m,char[] tmp) {
        int i = 0;
        while(m > 0) {
            int r1 = m % N;
            char r = func(r1);
            tmp[i] = r;
            i++;
            m = m / N;
        }
        return i;

    }
    public static char func(int r) {
        if(r < 10) {
            return (char)(r + '0');
        }
        switch(r) {
            case 10:
                return 'A';
            case 11:
                return 'B';
            case 12:
                return 'C';
            case 13:
                return 'D';
            case 14:
                return 'E';
            case 15:
                return 'F';
        }
        return '1';
    }
}


