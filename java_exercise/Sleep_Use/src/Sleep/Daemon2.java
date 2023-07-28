package Sleep;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-27
 * Time:22:49
 */
public class Daemon2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 3; i++) {
                System.out.println("t1  start");
            }

        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                    System.out.println("t2  run");
                }
            }
        });

        t1.start();
        System.out.println(t2.getState());
        t2.start();
    }
}
