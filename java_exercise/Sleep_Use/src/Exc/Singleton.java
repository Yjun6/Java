package Exc;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-29
 * Time:21:40
 */

//饿汉模式
public class Singleton {
    private static Singleton instance = new Singleton();
    public static Singleton getInstance(){
        return instance;
    }
    private Singleton(){}
}

class Main{
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);
    }
}