import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-10
 * Time:20:39
 */
public class Main3 {
    public static void main(String[] args) {
        File file1 = new File("./text1.txt");
        File file2 = new File("./t/text2.txt");
        //修改命名的同时，也能移动目录
        file1.renameTo(file2);
    }
}
