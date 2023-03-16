/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-16
 * Time:18:33
 */

//人类
class Person{
    public String name;//姓名
    public int age;//年龄
    public String sex;//性别

    //构造函数
    //初始化人这一个类
    public Person(){
        this.name = "黄帝";
        this.age = 35000;
        this.sex = "男性";
    }

    //学习的功能
    public void study(){
        System.out.println(this.name + "正在长脑子...");
    }
}

public class Constructor {
    public static void main(String[] args) {
        //使用Person类创建一个对象
        Person person1 = new Person();
        person1.study();

        Person person2 = new Person();
        person2.name = "炎帝";
        person2.study();
    }
}
