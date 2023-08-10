import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-10
 * Time:20:51
 */
public class Main4 {
    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader("./t/text2.txt");
        try {
        }finally {
            reader.close();
        }
    }
}
