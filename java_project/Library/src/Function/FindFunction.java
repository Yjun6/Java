package Function;

import Book.*;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-26
 * Time:16:16
 */
public class FindFunction implements IFunction {
    @Override
    public void work(BookList bookList) {
        System.out.println();
        System.out.println("******************************");
        System.out.println("查找图书！");
        System.out.println("请输入您要查找的图书：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        int num = bookList.getBookNum();
        for (int i = 0; i < num; i++) {
            if( bookList.book[i].getName().equals(name) ){
                System.out.println("找到了《"+name+"》这本书");
                System.out.println(bookList.book[i]);
                return;
            }
        }
        System.out.println("没找到了《"+name+"》这本书");
        System.out.println();
    }


}
