package User;

import Book.BookList;
import Function.IFunction;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User.User:Yu
 * Date:2023-03-23
 * Time:21:40
 */
public class User {
    private String name;
    public IFunction[] function;//功能数组

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public int menu(String name){
        return -1;
    }

    public void func(int choice, BookList bookList){
        return;
    }
}
