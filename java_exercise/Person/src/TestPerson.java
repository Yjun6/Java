/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class TestPerson {
    public static void main(String[] args) {
        Student student = new Student("S001","张三","学生",18000);
        Teacher teacher = new Teacher("T001","李四","老师",8000);
        student.register();
        student.login();
        student.talk(student);
        student.test();

        teacher.register();
        teacher.login();
        teacher.talk(teacher);
        teacher.work();
   }
}