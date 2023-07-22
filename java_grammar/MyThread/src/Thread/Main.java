package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-22
 * Time:21:42
 */

class Abc extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println("runrun");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Abc abc = new Abc();
        abc.start();

        while(true){
            System.out.println("main");
        }
    }
}
