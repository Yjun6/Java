/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-30
 * Time:21:30
 */

//阻塞队列
class MyBlockingQueue{
    private String[] elem = new String[10];
    //头
    volatile private int head;
    //尾
    volatile private int end;

    //锁
    Object lock = new Object();
    //插入
    public void put(String tmp) throws InterruptedException {
        synchronized (lock){
            while((end+1)%elem.length == head){
                //队列满了，阻塞
                lock.wait();
            }
            elem[end] = tmp;
            end++;
            if(end >= elem.length){
                end = 0;
            }
            lock.notify();
        }
    }

    //出队列
    public String take() throws InterruptedException {
        synchronized (lock){
            while(end == head){
                //队列空的，出队列阻塞
                lock.wait();
            }
            String tmp = elem[head];
            head++;
            if(head >= elem.length){
                head = 0;
            }
            lock.notify();
            return tmp;
        }
    }

}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue queue = new MyBlockingQueue();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    queue.put("abc");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
