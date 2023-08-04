import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-04
 * Time:20:29
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.submit(new Runnable() {
            @Override
            public void run() {
               while(true){
                   System.out.println(Thread.currentThread().getName()+111);
               }
            }
        });
        service.submit(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println(Thread.currentThread().getName()+222);
                }
            }
        });

    }
}
