import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-11
 * Time:15:35
 */
public class Main8 {
    public static void main(String[] args) throws IOException {
        try(OutputStream outputStream = new FileOutputStream("./t/text1.txt",true)){
            byte[] buf = new byte[10];
            buf[0] = 1;
            outputStream.write(buf);
        }

//        try(Writer writer = new FileWriter("./t/text1.txt")){
//            writer.write("wuli圣经欧尼~");
//        }
    }
}
