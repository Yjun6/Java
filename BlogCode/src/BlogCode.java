/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-20
 * Time:22:08
 */

class Stu{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void print(String name){
        System.out.println(name + "在学习");
    }

    public void getPrint(String name){
        print(name);
    }
}
public class BlogCode {
    public static void main(String[] args) {
        Stu stu = new Stu();
        stu.setName("大佬");
        stu.getPrint( stu.getName() );
    }
}
