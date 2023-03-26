package Function;


import Book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-26
 * Time:16:39
 */
public class ExitFunction implements IFunction{
    @Override
    public void work(BookList bookList) {
        System.out.println("退出系统");
        System.exit(0);
    }
}
