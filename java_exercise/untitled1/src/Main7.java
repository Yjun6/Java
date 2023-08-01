/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-01
 * Time:14:13
 */

class T extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println("111");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main7 {
    public static void main(String[] args) throws InterruptedException {

        T t = new T();
        //t.run();
        t.start();

        while(true){
            System.out.println("main");
            Thread.sleep(1000);
        }

    }
}
