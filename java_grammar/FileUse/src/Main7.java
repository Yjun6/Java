import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-11
 * Time:13:27
 */
public class Main7 {
    public static void main(String[] args) throws IOException {
        try(InputStream inputStream = new FileInputStream("./t/text2.txt")){
            Scanner scanner = new Scanner(inputStream);
            String  s = scanner.next();
            System.out.println(s);
        }
    }
}
