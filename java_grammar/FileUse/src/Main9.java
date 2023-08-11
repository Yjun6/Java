import java.io.File;
import java.util.Scanner;

class Main9{
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //输入目录
        System.out.print("请输入目录：");
        String root = scanner.next();
        File file = new File(root);
        //判断目录是否合法
        if(!file.isDirectory()){
            System.out.println("当前输入的目录"+root+"不合法");
            return ;
        }
        //输入单词
        System.out.print("请输入单词：");
        String word = scanner.next();
        deleteDir(file,word);
    }

    private static void deleteDir(File file,String word){
        File[] f1 = file.listFiles();
        if(f1 == null || f1.length == 0){
            return;
        }

        for (File f2: f1) {
            //为了调试，输出绝对路径
            System.out.println(f2.getAbsolutePath());

            if(f2.isFile()){
                //是文件
                if(f2.getName().contains(word)){
                    //存在目标单词
                    System.out.println("当前文件"+f2.getName()+"是否要删除(Y/N)");
                    String s = scanner.next();
                    if(s.equals("Y")||s.equals("y")){
                        f2.delete();
                    }
                }
            }
        }
    }
}