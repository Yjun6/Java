import java.io.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-11
 * Time:23:57
 */

//扫描指定目录，并找到名称或者内容中包含指定字符的所有普通文件（不包含目录）
public class Main11 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        //输入根目录
        System.out.print("请输入需要查找的根目录：");
        String root = scanner.next();
        File rootFile = new File(root);
        if(!rootFile.isDirectory()){
            System.out.println("目录不合法");
            return;
        }
        System.out.print("请输入指定字符：");
        String tmp = scanner.next();
        //查找
        select(rootFile,tmp);
    }

    //名称或者内容
    private static void select(File file,String word) throws IOException {
        //先找名称
        File[] buf = file.listFiles();
        if(buf == null || buf.length == 0){
            return;
        }
        for (File f:buf) {
            if(f.isFile()){
                //是一个普通文件
                if(f.getName().contains(word)){
                    //符合要求
                    System.out.println(f.getName());
                }else{
                    //找内容
                    boolean ret = selectDir(f,word);
                    if(ret){
                        //符合要求
                        System.out.println(f.getName());
                    }
                }
            }
        }
    }

    private static boolean selectDir(File file,String word) throws IOException {
        try(Reader reader = new FileReader(file)){
            while(true){
                char[] buf = new char[1024];
                int n = reader.read(buf);
                if(n == -1){
                    break;
                }
                String s = new String(buf,0,n);
                if(s.contains(word)){
                    return true;
                }
            }
        }
        return false;
    }
}
