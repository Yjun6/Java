/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-26
 * Time:21:18
 */
public class Student extends Person{
    int money;
    public Student(String id, String name, String job, int money) {
        super(id, name, job);
        this.money = money;
    }

    public void test(){
        System.out.println(this.name+"在考试！");
    }
}
