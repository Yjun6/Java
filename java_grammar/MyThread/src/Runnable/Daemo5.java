package Runnable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-25
 * Time:16:10
 */
public class Daemo5 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //执行
            }
        });
        t.start();
    }
}
