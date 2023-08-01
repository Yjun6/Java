/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-01
 * Time:12:47
 */

//TERMINATED
public class Main6 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
            }
        });

        t.start();
        while(true){
            System.out.println(t.getState());
            Thread.sleep(500);
        }
    }
}
