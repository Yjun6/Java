/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-26
 * Time:21:32
 */
public class Teacher extends Person{
    int salary;

    public Teacher(String id, String name, String job, int salary) {
        super(id, name, job);
        this.salary = salary;
    }

    public void work(){
        System.out.println(this.name+"在工作！");
    }
}
