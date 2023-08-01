/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-01
 * Time:12:26
 */

//就绪状态
public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.start();
        System.out.println(t.getState());
    }
}
