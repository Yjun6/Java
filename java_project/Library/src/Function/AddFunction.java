package Function;

import Book.*;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-25
 * Time:9:00
 */
public class AddFunction implements IFunction {
    @Override
    public void work(BookList bookList) {
        System.out.println();
        System.out.println("******************************");
        System.out.println("增加图书！");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您要增加的图书名字：");
        String name = scanner.nextLine();
        System.out.println("请输入您要增加的图书作者：");
        String author = scanner.nextLine();
        System.out.println("请输入您要增加的图书出版社：");
        String publication = scanner.nextLine();
        System.out.println("请输入您要增加的图书价格：");
        int price = scanner.nextInt();
        int num = bookList.getBookNum();
        bookList.book[num] = new Book(name, author, price, publication);
        bookList.setBookNum( num + 1 );

    }
}
