package Exc;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-29
 * Time:21:44
 */

//懒汉模式
public class SingletonLazy {
    private volatile static SingletonLazy instance = null;
    public static SingletonLazy getInstance(){
        if(instance == null){
            synchronized (SingletonLazy.class){
                if(instance == null){
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
    private SingletonLazy() {}
}

class Main1{
    public static void main(String[] args) {
        SingletonLazy singletonLazy = SingletonLazy.getInstance();
        System.out.println(singletonLazy);
    }
}