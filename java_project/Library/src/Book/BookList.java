package Book;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-23
 * Time:22:09
 */
public class BookList {
    private int bookMax = 10 ;//书架最大容量
    public Book[] book = new Book[bookMax];//书架
    private int bookNum;//当前书的数目

    public BookList(){
        this.book[0] = new Book("西游后传，大圣齐天", "网文作者", 24, "百度出版");
        this.book[1] = new Book("天使之耳", "东野圭吾", 34, "上海文艺出版社");
        this.book[2] = new Book("LINUX私房菜", "鸟哥", 56, "人民邮电出版社");

        this.bookNum = 3;
    }

    public void setBookMax(int bookMax) {
        this.bookMax = bookMax;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

    public int getBookMax() {
        return bookMax;
    }

    public int getBookNum() {
        return bookNum;
    }

}
