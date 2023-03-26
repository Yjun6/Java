package User;

import Book.BookList;
import Function.*;

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
        this.function = new IFunction[]{
                new ExitFunction(),
                new FindFunction(),
                new BorrowFunction(),
                new ReturnFunction(),
                new ShowFunction()
        };
    }
    public int menu(String name){
        System.out.println("*****************");
        System.out.println("欢迎"+name+"来到客户系统！");
        System.out.println("*****************");
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("4.显示图书");
        System.out.println("0.退出系统");
        System.out.println("*****************");

        System.out.print("请输入您的选择：");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

    @Override
    public void func(int choice, BookList bookList) {
        this.function[choice].work(bookList);
    }

}
