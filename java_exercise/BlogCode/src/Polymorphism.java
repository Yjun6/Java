/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-21
 * Time:21:01
 */
class Creature{
    String name;
    int age;

    public Creature(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println(this.name + "在吃午饭");
    }
}

class Person extends Creature{
    public Person(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(this.name + "在吃米饭");
    }
}

class Cat extends Creature{

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(this.name + "在吃猫粮");
    }
}

public class Polymorphism {

    public static void test(Creature creature){
        creature.eat();
    }

    public static void main(String[] args) {
        test(new Person("人类", 19));
        System.out.println("===========");

        test(new Cat("小猫", 2));
        System.out.println("===========");
    }
}