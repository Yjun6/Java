/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-01
 * Time:12:32
 */

//NEW
public class Main2 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.getState());
    }
}
