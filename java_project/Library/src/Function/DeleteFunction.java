package Function;

import Book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-26
 * Time:16:42
 */
public class DeleteFunction implements IFunction{
    @Override
    public void work(BookList bookList) {
        System.out.println();
        System.out.println("******************************");
        System.out.println("删除图书！");
        System.out.println("请输入您要删除的图书：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        int num = bookList.getBookNum();
        for (int i = 0; i < num; i++) {
            if( bookList.book[i].getName().equals(name) ){
                bookList.book[i] = bookList.book[num - 1];
                bookList.book[num - 1] = null;
                bookList.setBookNum(num-1);
                System.out.println("删除成功！");
                return;
            }
        }
        System.out.println("没有找到你要删除的图书！");
        System.out.println();
    }
}
