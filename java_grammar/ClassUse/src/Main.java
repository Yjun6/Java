/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

//定义一个类
class Dog{
    //属性
    public String name;//名字
    public int age;//年龄
    public String color;//颜色

    //方法
    public void eat() {
        System.out.println(this.name + "汪汪汪~");
    }
}

public class Main {
    public static void main(String[] args) {
        //定义一个Dog对象
        Dog dog = new Dog();
        dog.name = "小白狗";
        dog.age = 1;
        dog.color = "白色";
        dog.eat();

    }
}