import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-10
 * Time:20:20
 */
public class Main1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("./text1.txt");
        //创建文件
        file.createNewFile();
        //删除文件
        //file.delete();
        //程序退出在删除文件
        file.deleteOnExit();
    }
}
