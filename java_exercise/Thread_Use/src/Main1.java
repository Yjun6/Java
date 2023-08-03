import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-03
 * Time:13:15
 */

class MyTimer{
    //存储一个任务
    class TimerTake implements Comparable<TimerTake>{
        private long time;
        private Runnable runnable;
        TimerTake(Runnable runnable, long time){
            this.runnable = runnable;
            this.time = time+System.currentTimeMillis();
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
    //锁
    Object object = new Object();
    //组织任务
    private PriorityBlockingQueue<TimerTake> queue = new PriorityBlockingQueue<>();
    //一个线程执行这些任务
    class Take extends Thread{
        @Override
        public void run() {
            synchronized (object) {
                while(true) {
                    try {
                        while (queue.isEmpty()) {
                            //空队列 阻塞
                            object.wait();
                        }
                        TimerTake timerTake = queue.take();
                        long time = System.currentTimeMillis();
                        if (time >= timerTake.getTime()) {
                            //执行任务
                            timerTake.getRunnable().run();
                        } else {
                            //将任务添加回队列
                            queue.put(timerTake);
                            //等待时间
                            object.wait(timerTake.getTime() - time);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //任务接口
    public void schedule(Runnable runnable,long time){
        synchronized (object){
            TimerTake timerTake = new TimerTake(runnable,time);
            queue.put(timerTake);
            object.notify();
        }
    }

    //构造器
    MyTimer(){
        Take take = new Take();
        take.start();
    }

}
public class Main1 {
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
