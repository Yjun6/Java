import DoClassRoom.ClassRoom;
import StudentOneslfeImofrmation.StudentImfor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-18
 * Time:16:10
 */
public class invokeStu {
    public static void main(String[] args) {
        //创建一个学生
        StudentImfor stu1 = new StudentImfor("悟空", 20000);
        stu1.setAddress("花果山");
        System.out.println(stu1.name + "来自" + stu1.getAddress());

        System.out.println("班级是：" + ClassRoom.className);
        System.out.println("口号是：" + ClassRoom.slogan);

        StudentScore studentScore = new StudentScore();
        studentScore.javaScore = 87.5;
        studentScore.cppScore = 79;
        System.out.println(studentScore.javaScore);
        System.out.println(studentScore.cppScore);
    }
}
