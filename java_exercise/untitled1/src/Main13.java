/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-02
 * Time:11:50
 */
public class Main13 {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Thread t1 = new Thread(()->{
            synchronized (obj2){
                try {
                    obj2.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName());
        },"a");
        Thread t2 = new Thread(()->{
            synchronized (obj1){
                try {
                    obj1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName());
            synchronized (obj2){
                obj2.notify();
            }
        },"b");
        Thread t3 = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            synchronized (obj1){
                obj1.notify();
            }
        },"c");

        t1.start();
        t2.start();
        t3.start();
    }
}
