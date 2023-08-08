package Singleton;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-08
 * Time:19:32
 */

class Singleton{
    private static Singleton singleton = new Singleton();

    public static Singleton getSingleton() {
        return singleton;
    }

    private Singleton(){}
}

class SingletonLazy{
    volatile private static SingletonLazy singletonLazy = null;

    public static SingletonLazy getSingletonLazy() {
        if(singletonLazy == null) {
            synchronized (SingletonLazy.class) {
                if (singletonLazy == null) {
                    singletonLazy = new SingletonLazy();
                }
            }
        }
        return singletonLazy;
    }

    private SingletonLazy(){}
}

public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
        SingletonLazy singletonLazy = SingletonLazy.getSingletonLazy();
    }
}
