import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-02
 * Time:14:42
 */

//定时器模拟
//描述一个任务
class TimerTake implements Comparable<TimerTake> {
    private Runnable runnable;
    private long time;

    public Runnable getRunnable() {
        return runnable;
    }

    public long getTime() {
        return time;
    }

    TimerTake(Runnable runnable,long time){
        this.runnable = runnable;
        this.time = System.currentTimeMillis()+time;
    }

    @Override
    public int compareTo(TimerTake o) {
        return (int)(this.time-o.time);
    }
}
//组织任务
class MyTimer{
    private PriorityBlockingQueue<TimerTake> queue = new PriorityBlockingQueue();
    static Object object = new Object();
    public void schecule(Runnable runnable,long time){
        TimerTake timerTake = new TimerTake(runnable,time);
        synchronized (object){
            queue.put(timerTake);
            object.notify();
        }
    }

    class Work extends Thread{
        @Override
        public void run() {
            while(true){
                synchronized (object){
                    try {
                        while(queue.isEmpty()){
                                object.wait();
                        }
                        long time = System.currentTimeMillis();
                        if(time >= queue.peek().getTime()){
                            queue.take().getRunnable().run();
                        }else{
                            object.wait(queue.peek().getTime()-time);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    MyTimer(){
        Work work = new Work();
        work.start();
    }

}

public class Main {
    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();
        myTimer.schecule(new Runnable() {
            @Override
            public void run() {
                System.out.println("222");
            }
        },2000);

        myTimer.schecule(new Runnable() {
            @Override
            public void run() {
                System.out.println("333");
            }
        },3000);myTimer.schecule(new Runnable() {
            @Override
            public void run() {
                System.out.println("111");
            }
        },1000);

    }
}
