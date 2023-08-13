import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-13
 * Time:19:34
 */

class MyExecutor{
    private int num;//线程数量
    MyExecutor(int num){
        this.num = num;
        MyTake myTake = new MyTake();
        myTake.start();
    }

    volatile BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    static Object object = new Object();
    class MyTake extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < num; i++) {
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        synchronized (object) {
                            try {
                                //为了使线程池一直处于运行状态
                                while(true){
                                    //执行任务
                                    while (queue.isEmpty()) {
                                        object.wait();
                                    }
                                    Runnable runnable = queue.take();
                                    runnable.run();
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };
                thread.start();
            }
        }
    }

    public void submit(Runnable runnable){
        synchronized (object){
            try {
                queue.put(runnable);
                object.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

public class Main {
    public static void main(String[] args) {
        MyExecutor myExecutor = new MyExecutor(4);
        myExecutor.submit(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"   123");
                }
            }
        });
    }
}
