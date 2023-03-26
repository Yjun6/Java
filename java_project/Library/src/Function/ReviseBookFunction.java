package Function;

import Book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-25
 * Time:9:00
 */
public class ReviseBookFunction implements IFunction {
    public void work(BookList bookList){
        System.out.println();
        System.out.println("******************************");
        System.out.println("修改图书！");
        System.out.println("请输入您要修改的图书：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        int num = bookList.getBookNum();
        for (int i = 0; i < num; i++) {
            if( bookList.book[i].getName().equals(name) ){
                System.out.println("请输入您要修改的价格：");
                int price = scanner.nextInt();
                bookList.book[i].setPrice(price);
                System.out.println("修改成功！");
                System.out.println(bookList.book[i]);
                return;
            }
        }
        System.out.println("没有找到你要修改的图书！");
        System.out.println();
    }
}
