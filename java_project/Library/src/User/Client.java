package User;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-23
 * Time:21:43
 */
public class Client extends User{
    public Client(String name) {
        super(name);
    }
    public int menu(){
        System.out.println("*****************");
        System.out.println("欢迎来到客户系统！");
        System.out.println("*****************");
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("0.退出系统");
        System.out.println("*****************");

        System.out.print("请输入您的选择：");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
