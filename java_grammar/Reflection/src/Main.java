/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

class Student{
    private String name = "bit";
    int id = 7;

    private Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Student() {
    }

    private void eat(String s){
        System.out.println(s);
    }
    public void speak(){
        System.out.println("speak");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.
        Student s1 = new Student();
        Class<?> c1 = s1.getClass();
        //2.
        Class<?> c2 = Student.class;
        //3.
        Class<?> c3 = Class.forName("Student");

    }
}










