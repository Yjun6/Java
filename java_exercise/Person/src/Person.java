/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-26
 * Time:21:13
 */
public class Person {
    String id;
    String name;
    String job;

    public Person(String id, String name, String job) {
        this.id = id;
        this.name = name;
        this.job = job;
    }

    public void login(){
        System.out.println(this.name+"登录成功！");
    }

    public void register(){
        System.out.println(this.name+"注册成功！");
    }

    public void talk(Person person){
        System.out.println(person);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
