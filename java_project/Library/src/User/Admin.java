package User;

import Book.BookList;
import Function.*;

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
        this.function = new IFunction[]{
            new ExitFunction(),
            new FindFunction(),
            new AddFunction(),
            new DeleteFunction(),
            new ReviseBookFunction(),
            new ShowFunction()
        };
    }

    public int menu(String name){
        System.out.println("*****************");
        System.out.println("欢迎"+name+"来到管理员系统！");
        System.out.println("*****************");
        System.out.println("1.查找图书");
        System.out.println("2.增加图书");
        System.out.println("3.删除图书");
        System.out.println("4.修改图书");
        System.out.println("5.显示图书");
        System.out.println("0.退出系统");
        System.out.println("*****************");

        System.out.print("请输入您的选择：");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

    public void func(int choice, BookList bookList){
        function[choice].work(bookList);
    }
}
