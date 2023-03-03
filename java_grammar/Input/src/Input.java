import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-03
 * Time:19:57
 */
public class Input {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //string
        //1
        String name1 = scan.nextLine();
        System.out.println(name1);
        //2
        String name2 = scan.next();
        System.out.println(name2);
        //int
        int a = scan.nextInt();
        System.out.println(a);
        //float
        float b = scan.nextFloat();
        System.out.println(b);
        //byte
        byte c = scan.nextByte();
        System.out.println(c);
        //boolean
        boolean d = scan.nextBoolean();
        System.out.println(d);

        //多次读取数据
        while(scan.hasNextInt()){
            int a1 = scan.nextInt();
            System.out.println(a1);
        }

    }
}
