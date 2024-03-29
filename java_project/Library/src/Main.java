import Book.BookList;
import User.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User.User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    private static User login(String name){
        System.out.println("请输入您的身份：1>管理员 2>客户");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        User user;
        if(choice == 1){
            user = new Admin(name);
        }else{
            user = new Client(name);
        }
        return user;
    }

    public static void main(String[] args) {
        //创建书架
        BookList bookList = new BookList();

        System.out.print("请输入您的名字：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        //登录
        User user = Main.login(name);
        while(true){
            int ret = user.menu(name);
            user.func(ret,bookList);
        }
    }
}