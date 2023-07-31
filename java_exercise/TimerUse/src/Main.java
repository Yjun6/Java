import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-31
 * Time:20:04
 */

//使用定时器
public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("2s");
            }
        },2000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("1s");
            }
        },1000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("3s");
            }
        },3000);

    }
}
