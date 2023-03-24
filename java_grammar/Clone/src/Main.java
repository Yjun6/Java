/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

class Stu implements Cloneable{
    int age;

    Money m = new Money();

    public Stu(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "age=" + age +
                ", m=" + m +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Stu s = (Stu)super.clone();
        s.m = (Money) this.m.clone();
        return s;
    }
}

class Money implements Cloneable {
    int money;

    @Override
    public String toString() {
        return "Money{" +
                "money=" + money +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class Main {
    //深拷贝
    public static void main(String[] args) throws CloneNotSupportedException {
        Stu s1 = new Stu(12);
        s1.m.money = 234;
        Stu s2 = (Stu)s1.clone();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("============");
        s1.m.money = 134;
        System.out.println(s1);
        System.out.println(s2);
    }

    //浅拷贝
    public static void main1(String[] args) throws CloneNotSupportedException {
        Stu s1 = new Stu(12);
        Stu s2 = (Stu)s1.clone();
    }
}
