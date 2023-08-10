import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-10
 * Time:20:33
 */
public class Main2 {
    public static void main(String[] args) {
        //File file = new File("./t");
        File file = new File("./111/t");
        //创建一层目录
        //file.mkdir();
        //创建多层
        file.mkdirs();
    }
}
