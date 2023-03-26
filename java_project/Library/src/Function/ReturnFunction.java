package Function;

import Book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-26
 * Time:17:17
 */
public class ReturnFunction implements IFunction{
    @Override
    public void work(BookList bookList) {
        System.out.println();
        System.out.println("******************************");
        System.out.println("归还图书！");
        System.out.println("请输入您要归还的图书：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        int num = bookList.getBookNum();
        for (int i = 0; i < num; i++) {
            if( bookList.book[i].getName().equals(name) ){
                bookList.book[i].setIsBorrowed(false);
                System.out.println("归还成功！");
                return;
            }
        }
        System.out.println("没找到您要归还的图书");
        System.out.println();
    }
}
