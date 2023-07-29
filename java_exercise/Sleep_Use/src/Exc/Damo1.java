package Exc;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-28
 * Time:19:39
 */

public class Damo1 {
    private static volatile int tmp = 0;
    public static void main(String[] args) {
        Object obj = new Object();
        //使用wait方法
        Thread t1 =  new Thread(()->{
            synchronized (obj){
                try {
                    obj.wait();
                    tmp++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("1111");
        });
        //使用notify
        Thread t2 =  new Thread(()->{
            synchronized (obj){
                obj.notify();
            }
            System.out.println("1112");
        });

        t1.start();
        t2.start();
    }
}
