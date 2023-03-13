import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 5, 6};
        int[] arr2 = {1, 3, 4, 5, 6};
        boolean f = Arrays.equals(arr1, arr2);
        Arrays.fill(arr1, 1, 3, 0);
    }

    public static void main2(String[] args) {
        int[][] arr1 = {{1, 3, 4}, { 5, 6 }};
        String arr2 = Arrays.deepToString(arr1);

    }

    public static void main1(String[] args) {
        int[] arr1 = {1, 3, 4, 5, 6};
        int[] arr2 = Arrays.copyOf(arr1, arr1.length + 5);
        arr2[0] = -1;
    }
}