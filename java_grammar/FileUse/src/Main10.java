import java.io.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-11
 * Time:22:02
 */

//进行普通文件的复制
public class Main10 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        System.out.print("请输入需要拷贝的文件路径：");
        String root = scanner.next();
        //String root = "./t/text1.txt";
        File file1 = new File(root);
        //判断路径是否合法
        if(!file1.isFile()){
            //不合法
            System.out.println("当前路径不合法！");
            return;
        }
        System.out.print("请输入需要拷贝到的目标文件：");
        String dir = scanner.next();
        //String dir = "./t/t2.txt";
        File file2 = new File(dir);

        if(!file2.getParentFile().isDirectory()){
            //绝对路径是否存在
            System.out.println(dir+"文件路径非法！");
        }
        //拷贝文件
        copyFile(file1,file2);
    }

    private static void copyFile(File f1, File f2) throws IOException {
        try(InputStream inputStream = new FileInputStream(f1);
        OutputStream outputStream = new FileOutputStream(f2)){
            while (true) {
                byte[] buf = new byte[1024];
                int n = inputStream.read(buf);
                System.out.println("n=" + n);
                if (n == -1) {
                    System.out.println("拷贝完成");
                    break;
                }
                outputStream.write(buf, 0, n);
            }
        }
    }

}









