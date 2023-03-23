import Book.BookList;
import User.*;
import javax.jws.soap.SOAPBinding;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User.User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    public static void main(String[] args) {
        System.out.print("请输入您的名字：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("请输入您的身份：1>管理员 2>客户");
        int choice = scanner.nextInt();

        User user;
        if(choice == 1){
            user = new Admin(name);
        }else{
            user = new Client(name);
        }

        int ret = user.menu();
        //创建书架

    }
}