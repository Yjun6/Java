package Runnable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-25
 * Time:10:47
 */
public class Daemo4 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            while(true){
                System.out.println("run run");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        try {
            Thread.sleep(1000);
            t.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("111");
    }
}
