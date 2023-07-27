package Sleep;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-27
 * Time:20:42
 */
public class Daemon1 {
    static char tmp = 'a';
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for(int i=0;i<26;i++){
                tmp = (char)('a'+i);
                System.out.println(tmp);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()->{
            while(true){
                Scanner scanner = new Scanner(System.in);
                char ch = scanner.next().charAt(0);
                if(ch == tmp){
                    System.out.println("   yes");
                }else{
                    System.out.println("   no");
                }
            }

        });

        t1.start();
        t2.start();
    }
}
