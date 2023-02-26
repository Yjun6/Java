import java.sql.SQLOutput;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-02-26
 * Time:23:33
 */
public class StringInt {

    public static void main(String[] args) {
        //1
        String arr1 = "邹雨洁 ";
        int arr2 = 19;
        System.out.println(arr1 + arr2);
        System.out.println("========");

        //2
        int arr3 = 2013;
        String arr4 = String.valueOf(arr3);
        System.out.println(arr4);
        System.out.println("========");

        System.out.println("=========");
        String arr5 = "456";
        int arr6 = Integer.parseInt(arr5);
        System.out.println(arr6);

    }
}
