/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-08
 * Time:13:02
 */
public class Main {
    static int count1 = 0;
    static int count2 = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    count1++;
                }
            }
        });

        t.start();
        for (int i = 0; i < 100000; i++) {
            count2++;
        }
        t.join();
        System.out.println(count1);
        System.out.println(count2);
    }
}
