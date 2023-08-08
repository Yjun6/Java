package Timer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-08
 * Time:21:29
 */
public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("111");
            }
        },1000);

        BlockingQueue<Integer> queue1 = new LinkedBlockingQueue<>();
        BlockingQueue<Integer> queue2 = new PriorityBlockingQueue<>();
        BlockingQueue<Integer> queue3 = new ArrayBlockingQueue<>(12);
    }
}
