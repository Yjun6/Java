package MyTimer;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-09
 * Time:10:39
 */

class TimerTake implements Comparable<TimerTake>{
    private long time;
    private Runnable runnable;

    public TimerTake( Runnable runnable,long time) {
        this.time = time+System.currentTimeMillis();//当前时间+等待时间
        this.runnable = runnable;
    }

    public long getTime() {
        return time;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    @Override
    public int compareTo(TimerTake o) {
        return (int)(this.time-o.time);
    }
}

class MyTimer {
    volatile private PriorityBlockingQueue<TimerTake> queue = new PriorityBlockingQueue<TimerTake>();

    public void schedule(Runnable runnable, long time) {
        synchronized (object) {
            TimerTake timerTake = new TimerTake(runnable, time);
            queue.put(timerTake);
            object.notify();
        }
    }

    private static Object object = new Object();

    class Timer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    synchronized (object) {
                        while (queue.isEmpty()) {
                            //空队列，没有任务
                            object.wait();
                        }
                        TimerTake timerTake = queue.take();
                        long time = System.currentTimeMillis();//当前时间
                        if (time >= timerTake.getTime()) {
                            //执行任务
                            timerTake.getRunnable().run();
                        } else {
                            //将任务添加回去
                            queue.put(timerTake);

                            object.wait(timerTake.getTime() - time);

                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    MyTimer(){
        Timer timer = new Timer();
        timer.start();
    }
}

public class Main {
    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("111");
            }
        },1000);
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("333");
            }
        },3000);
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("222");
            }
        },2000);
    }
}











