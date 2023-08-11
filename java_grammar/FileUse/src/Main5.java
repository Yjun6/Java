import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-11
 * Time:13:04
 */
public class Main5 {
    public static void main(String[] args) throws IOException {
       try( Reader reader = new FileReader("./t/text2.txt")){
           while(true){
               char[] buf = new char[10];
               int n = reader.read(buf);
               if(n == -1){
                   break;
               }
               for (int i = 0; i < n; i++) {
                   System.out.print(buf[i]);
               }
           }
       }
    }
}
