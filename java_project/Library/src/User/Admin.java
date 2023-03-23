package User;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-23
 * Time:21:42
 */
public class Admin extends User{
    public Admin(String name) {
        super(name);
    }
    public int menu(){
        System.out.println("*****************");
        System.out.println("欢迎来到管理员系统！");
        System.out.println("*****************");
        System.out.println("1.查找图书");
        System.out.println("2.增加图书");
        System.out.println("3.删除图书");
        System.out.println("4.修改图书");
        System.out.println("0.退出系统");
        System.out.println("*****************");

        System.out.print("请输入您的选择：");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
