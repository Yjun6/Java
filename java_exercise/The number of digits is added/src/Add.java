/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-07
 * Time:19:50
 */
public class Add {
    public static void main(String[] args) {
        int num = 121432;
        System.out.println(add(num));
    }

    public static int add (int num) {
        if(num <= 9){
            return num;
        }else{
          return (num % 10) + add(num / 10);
        }
    }
}
