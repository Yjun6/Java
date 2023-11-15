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
            int[][] num = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    num[i][j] = in.nextInt();
                }
            }
            int[][] is_num = new int[n][m];
            List<Integer[]> minlist = new ArrayList<>();
            List<Integer[]> list = new ArrayList<>();
            func(num,is_num,0,0,0,n*m,list,minlist);
            for (Integer[] tmp : minlist) {
                System.out.println("(" + tmp[0] + "," + tmp[1] + ")");
            }
        }
    }
    public static void func(int[][] num, int[][] is_num, int x, int y, int len, int minlen, List<Integer[]> list, List<Integer[]> minlist) {
        if (x < 0 || y < 0 || x >= num.length || y >= num[0].length 
        || is_num[x][y] == 1 || num[x][y] == 1) {
            //越界 已经走过了 有障碍
            return;
        }
        //录入元素
        Integer[] tmp = {x,y};
        list.add(tmp);
        is_num[x][y] = 1;
        len++;
        if (x == num.length - 1 && y == num[0].length - 1) {
            if (len < minlen) {
                //交换数组
                minlist.clear();
                for (Integer[] l : list) {
                    minlist.add(l);
                }
                minlen = len;
            }
        }
        //横竖
        func(num,is_num,x+1,y,len,minlen,list,minlist);
        func(num,is_num,x-1,y,len,minlen,list,minlist);
        func(num,is_num,x,y+1,len,minlen,list,minlist);
        func(num,is_num,x,y-1,len,minlen,list,minlist);
        //出元素
        list.remove(tmp);
        len--;
        is_num[x][y] = 0;
    }
}








