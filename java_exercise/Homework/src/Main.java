/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    public static void main(String[] args){
        int[][] arr = {{11},{21,22},{31,32,33},{41,42,43,44}};
        for (int i = 0 ;i < arr.length; i++) {
            for (int j = 0 ;j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}