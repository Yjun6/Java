import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-14
 * Time:22:19
 */

//模拟实现线程池
class MyExcutor{
    private int num;
    MyExcutor(int num) {
        this.num = num;
        for (int i = 0; i < num; i++) {
            Take take = new Take();
            Thread t = new Thread(take);
            t.start();
        }
    }

    volatile static BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    public void submit(Runnable runnable){
        try {
            synchronized (object) {
                queue.put(runnable);
                object.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Object object = new Object();
    private class Take implements Runnable{
        @Override
        public void run() {
            synchronized (object){
                try {
                    while(true){
                        while(queue.isEmpty()){
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
    }
}

public class Main {
    static int tmp = 0;
    public static void main(String[] args) {
        MyExcutor excutor = new MyExcutor(4);
        excutor.submit(new Runnable() {
            @Override
            public void run() {
                while(true){
                    tmp++;
                    System.out.println(tmp);
                    System.out.println(Thread.currentThread().getName()+"   ");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
