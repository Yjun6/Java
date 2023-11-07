/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-07
 * Time:22:50
 */
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
class HJ64_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            // int a = in.nextInt();
            // int b = in.nextInt();
            // System.out.println(a + b);
            int tmp = in.nextInt();//歌曲总数
            int index = 1;//当前下标
            String ch = in.next();
            char[] chUD = ch.toCharArray();//操作字符
            int indexStart = 1;//当前页第一首歌
            int len = ch.length();
            //歌曲总数<=4
            if (tmp <= 4) {
                for (int i = 0; i < len; i++) {
                    //光标在第一首歌曲上时，按Up键光标挪到最后一首歌曲；
                    if (index == 1 && chUD[i] == 'U') {
                        index = tmp;
                    }
                    //光标在最后一首歌曲时，按Down键光标挪到第一首歌曲。
                    else if (index == tmp && chUD[i] == 'D') {
                        index = 1;
                    }
                    //其他情况下用户按Up键，光标挪到上一首歌曲
                    else if (chUD[i] == 'U') {
                        index--;
                    }
                    //用户按Down键，光标挪到下一首歌曲。
                    else if (chUD[i] == 'D') {
                        index++;
                    }
                }
                //输出歌曲数量
                for (int i = 1; i < tmp; i++) {
                    System.out.print(i + " ");
                }
                System.out.println(tmp);
                //输出当前歌曲
                System.out.print(index);
            } else {
                for (int i = 0; i < len; i++) {
                    //屏幕显示的是第一页（即显示第1 – 4首）时，
                    //光标在第一首歌曲上，用户按Up键后，
                    //屏幕要显示最后一页（即显示第7-10首歌），同时光标放到最后一首歌上。
                    if (indexStart == 1 && index == 1 && chUD[i] == 'U') {
                        indexStart = tmp - 3;
                        index = tmp;
                    }
                    //同样的，屏幕显示最后一页时，
                    //光标在最后一首歌曲上，用户按Down键，屏幕要显示第一页，光标挪到第一首歌上。
                    else if (indexStart == tmp - 3 && index == tmp && chUD[i] == 'D') {
                        indexStart = 1;
                        index = 1;
                    }
                    //屏幕显示的不是第一页时，光标在当前屏幕显示的第一首歌曲时，
                    //用户按Up键后，屏幕从当前歌曲的上一首开始显示，光标也挪到上一首歌曲。
                    else if (indexStart != 1 && index == indexStart && chUD[i] == 'U') {
                        indexStart--;
                        index--;
                    }
                    //光标当前屏幕的最后一首歌时的Down键处理也类似。
                    else if (indexStart != tmp - 3 && index == indexStart + 3 && chUD[i] == 'D') {
                        indexStart++;
                        index++;
                    }
                    //不用翻页，只是挪动光标就行
                    else if (chUD[i] == 'D') {
                        index++;
                    } else if (chUD[i] == 'U') {
                        index--;
                    }
                }
                for (int i = indexStart; i < indexStart + 3; i++) {
                    System.out.print(i + " ");
                }
                System.out.println(indexStart + 3);
                //输出当前歌曲
                System.out.print(index);
            }
        }
    }
}
