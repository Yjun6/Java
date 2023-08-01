/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-01
 * Time:12:41
 */

//WAITING
public class Main4 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            synchronized (Main3.class){
                try {
                    Main3.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        while(true){
            System.out.println(t1.getState());
            Thread.sleep(500);
        }
    }
}
