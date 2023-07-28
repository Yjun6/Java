package Sleep;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-27
 * Time:22:55
 */
public class Daemon3 {
    static int tmp = 0;
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    //tmp++;
                    synchronized(obj){
                        tmp++;
                    }
                }
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 30000; i++) {
                synchronized(obj){
                    tmp++;
                }
            }
        });

        t.start();
        t2.start();
        t.join();
        t2.join();

        System.out.println(tmp);
    }
}
