package Function;

import Book.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-26
 * Time:18:37
 */
public class ShowFunction implements IFunction{

    @Override
    public void work(BookList bookList) {
        for (int i = 0; i <  bookList.getBookNum(); i++) {
            System.out.println(bookList.book[i]);
        }
    }
}
