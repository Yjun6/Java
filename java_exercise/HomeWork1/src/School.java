/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-04-10
 * Time:15:58
 */
public class School implements ComputerAverage{
    @Override
    public double aver(double[] arr) {
        double sum = 0.0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum/arr.length;
    }
}
