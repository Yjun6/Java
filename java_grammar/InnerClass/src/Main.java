/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

interface E{
    abstract void e();
}

class A implements E{
    void aaa(){
        System.out.println("aaa1");
    }
    //实例内部类
    class B{
        int a = 1;
        void aaa(){
            System.out.println("aaa2");
        }
        public static final int n = 2;

        void b1(){
            A.this.aaa();
        }
    }
    //静态内部类
    int c1 = 2;
    static int c2 = 34;
    static class C{
        void print(){
            //c1不是静态常量
            //System.out.println(c1);
            System.out.println(c2);
        }
    }
    //局部内部类
    void d1(){
        class D{
            void dd(){
                System.out.println("d1.d.dd()");
            }
        }

        D d = new D();
        d.dd();
    }
    //匿名内部类

    @Override
    public void e() {
        System.out.println( "ee");
    }
}
public class Main {
    public static void main(String[] args) {
        A a = new A();
        A.B b = a.new B();
        b.b1();
        System.out.println("==============================");
        //静态实例类
        A.C c = new A.C();
        c.print();
        System.out.println("=============================");
        //局部实例类
        a.d1();
        System.out.println("================================");
        //匿名内部类
        int er = 12;
        new E(){

            @Override
            public void e() {
                System.out.println(er + "E.ee");
            }
        }.e();
    }
}