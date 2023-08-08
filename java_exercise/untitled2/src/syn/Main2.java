package syn;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-08
 * Time:15:07
 */
public class Main2 {
    static Object object = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    //语句1
                    System.out.println("语句1");
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //语句2
                    System.out.println("语句2");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    //语句3
                    System.out.println("语句3");
                    object.notify();
                    //语句4
                    System.out.println("语句4");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
