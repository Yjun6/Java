import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-24
 * Time:15:56
 */
public class Main {
    volatile static Semaphore s = new Semaphore(10);
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
               while(true){
                   try {
                       s.acquire();
                       System.out.println(s);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        s.acquire();
                        System.out.println(s);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
