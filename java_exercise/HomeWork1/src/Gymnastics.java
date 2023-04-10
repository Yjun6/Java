import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-04-10
 * Time:15:58
 */
public class Gymnastics implements ComputerAverage{
    @Override
    public double aver(double[] arr) {
        Arrays.sort(arr);
        double[] arr1 = new double[arr.length-2];
        arr1 = Arrays.copyOfRange(arr,1,arr.length-1);
        double sum = 0.0;
        for (int i = 0; i < arr1.length; i++) {
            sum += arr1[i];
        }
        return sum/arr1.length;
    }
}
