package Book;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-23
 * Time:22:06
 */
public class Book {
    private String name;//书名
    private String author;//作者
    private int price;//价格
    private String publication;//出版社
    private boolean isBorrowed;//是否被借出

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public Book(String name, String author, int price, String publication) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.publication = publication;
    }

    public boolean getIsBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", publication='" + publication + '\'' +
                ( isBorrowed ?"已借出":"未借出")+
                '}';
    }
}
