/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-01
 * Time:12:33
 */

//BLOCKED
public class Main3 {
    static int count = 0;
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            synchronized (Main3.class){
                count++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()->{
            synchronized (Main3.class){
                count++;
            }
        });

        t1.start();
        t2.start();
        while(true){
            System.out.println(t2.getState());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
