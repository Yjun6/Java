package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-31
 * Time:22:45
 */
public class Main1 {
    private static int count = 0;
    public static void main(String[] args) {
        //int count = 0;
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(count < 3){
                    System.out.println("执行语句");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                count++;
            }
        });

        t1.start();
        t2.start();
    }
}
