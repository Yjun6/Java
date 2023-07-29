package Sleep;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-27
 * Time:23:11
 */
public class Daemon4 {
    static volatile int tmp = 0;

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            while(tmp == 0){
//                System.out.println("111");
            }
            System.out.println("222");
        });

        Thread t2 =  new Thread(()->{
            tmp = new Scanner(System.in).nextInt();
        });

        t.start();
        t2.start();
    }
}
