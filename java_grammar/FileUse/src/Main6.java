import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-11
 * Time:13:16
 */
public class Main6 {
    public static void main(String[] args) throws IOException {
        try(InputStream inputStream = new FileInputStream("./t/text2.txt")){
            while(true){
                byte[] buf = new byte[100];
                int n = inputStream.read(buf);
                if(n == -1) break;
//                for (int i = 0; i < n; i++) {
//                    System.out.printf("%x ",buf[i]);
//                }
                String s = new String(buf,0,n);
                System.out.println(s);
            }
        }
    }
}
