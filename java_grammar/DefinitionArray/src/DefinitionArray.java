/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-08
 * Time:19:04
 */
public class DefinitionArray {

    public static void main(String[] args) {
        boolean[] array1 = new boolean[5];//false

        String[] array2 = new String[5];//null ->

        char[] array3 = new char[5];//
    }

    public static void main1(String[] args) {
        //创建数组
        //1.
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        //2.        不太推荐
        int arr2[] = {1, 2, 3, 4, 5, 6};
        //3.        1 3 没有区别，1是3的语法简化
        int[] arr3 = new int[]{1, 2, 3, 4, 5, 6};
        //4.        全是0
        int[] arr4 = new int[6];

        int[] arr5;
        arr5 = new int[5];

        int[] arr6;
        arr6 = new int[]{1, 2, 3, 4, 5, 6};
    }
}
