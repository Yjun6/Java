import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-05
 * Time:20:04
 */

//CAS 原子类
public class Main {
    private static AtomicInteger count = new AtomicInteger(10);
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            while(true){
                try {
                    count.addAndGet(1);
                    System.out.println(count.get()+"  "+Thread.currentThread().getName());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()->{
            while(true){
                try {
                    count.addAndGet(1);
                    System.out.println(count.get()+"  "+Thread.currentThread().getName());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
