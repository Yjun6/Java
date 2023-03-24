/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */


class A {
    void test1(){
        System.out.println("A");
    }
}

class B extends A{
    void test2(){
        System.out.println("B");
    }
}

class C extends A{
    void test3(){
        System.out.println("C");
    }
}

public class Main {
    public static void main(String[] args) {
        A a = new B();
        if(a instanceof B){
            B b = (B)a;
            b.test2();
        }else if(a instanceof C){
            C c = (C)a;
            c.test3();
        }
        System.out.println("============");

        a = new C();
        if(a instanceof B){
            B b = (B)a;
            b.test2();
        }else if(a instanceof C){
            C c = (C)a;
            c.test3();
        }
        System.out.println("============");
    }
}