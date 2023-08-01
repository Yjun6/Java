/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-01
 * Time:15:22
 */

//
public class Main12 {
    static Object object = new Object();
    static Object object1 = new Object();
    static Object object2 = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                synchronized (object){
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("A");
                synchronized (object1){
                    object1.notify();
                }
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                synchronized (object1) {
                    try {
                        object1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("B");
                }
                synchronized (object2){
                    object2.notify();
                }
            }
        });
        Thread t3 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                synchronized (object2) {
                    try {
                        object2.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("C");
                synchronized (object){
                    object.notify();
                }
            }
        });

            t1.start();
            t2.start();
            t3.start();
            Thread.sleep(500);
            synchronized (object){
                object.notify();
            }

    }
}
