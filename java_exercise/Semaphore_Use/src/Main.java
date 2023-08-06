import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-06
 * Time:20:02
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(5);
        semaphore.acquire();//--操作
        System.out.println(semaphore);
        semaphore.acquire();
        System.out.println(semaphore);
        semaphore.acquire();//--操作
        System.out.println(semaphore);
        semaphore.acquire();
        System.out.println(semaphore);
        semaphore.acquire();//--操作
        System.out.println(semaphore);
        semaphore.acquire();
        System.out.println(semaphore);
    }
}
