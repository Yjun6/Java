package Runnable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-23
 * Time:13:33
 */

class MyRunnable implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("hello run");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Doma2 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        while(true){
            System.out.println("111");
            Thread.sleep(1000);
        }
    }
}
