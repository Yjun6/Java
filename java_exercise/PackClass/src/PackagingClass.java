/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-04-02
 * Time:20:00
 */
public class PackagingClass {
    public static void main(String[] args) {
        Integer a = 19;
        int a1 = a.intValue();//显示拆箱
        int a2 = a;//自动拆箱
    }

    public static void main1(String[] args) {
        int a = 10;
        Integer a1 = a;//自动装箱
        Integer a3 = Integer.valueOf(a);//显示装箱
        Integer a2 = new Integer(a);//显示装箱
    }

}
