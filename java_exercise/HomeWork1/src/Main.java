/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    public static void main(String[] args) {
        double[] arr1 = {25, 46, 79, 23, 67, 12};
        Gymnastics stu1 = new Gymnastics();
        System.out.println("stu1的平均成绩是："+stu1.aver(arr1));
        double[] arr2 = {48,49,16,59,56};
        Gymnastics stu2 = new Gymnastics();
        System.out.println("stu2的平均成绩是："+stu2.aver(arr2));
        System.out.println("=========================");
        School school = new School();
        double[] all = {89,68,78,49,58};
        System.out.println("班级平均考试成绩："+school.aver(all));

    }
}