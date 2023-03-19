/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

class X{
    Y y=new Y();//1
    public X(){//2
        System.out.print("X");
    }
}
class Y{
    public Y(){//3
        System.out.print("Y");
    }
}
public class Main extends X{
    Y y=new Y();//4
    public Main(){//5
        System.out.print("Z");
    }
    public static void main(String[] args) {
        new Main();
    }
}


//class stu{
//    String name;
//    public stu(){
//        System.out.println("stu");
//    }
//}

//public class Main1 extends stu {
//    public Main1() {
//        System.out.println("123");
//    }
//    public static void main1(String[] args) {
//        new Main1();
//
//    }
//}