/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-01
 * Time:15:17
 */

//每个线程循环 1w 次，累加变量 count 的值，count 默认值为 0，注意线程安全问题。
public class Main11 {
    volatile static int count = 0;
    static Object obj = new Object();
    public static void main(String[] args) throws InterruptedException {
        int num = 1_0000;
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < num; i++) {
                    synchronized (obj){
                        count++;
                    }
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < num; i++) {
                    synchronized (obj){
                        count++;
                    }
                }
            }
        };

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
