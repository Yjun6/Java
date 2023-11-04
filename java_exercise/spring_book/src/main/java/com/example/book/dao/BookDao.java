package com.example.book.dao;

import com.example.book.model.BookInfo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-03
 * Time:20:00
 */
@Component
public class BookDao {
    public List<BookInfo> mockData() {
        List<BookInfo> bookInfos = new ArrayList<>(15);
        for (int i = 0; i < 15; i++) {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(i);
            bookInfo.setBookName("图书" + i);
            bookInfo.setAuthor("作者" + i);
            bookInfo.setCount(new Random().nextInt(200));
            bookInfo.setPrice(new BigDecimal(new Random().nextInt(100)));
            bookInfo.setPublish("出版社" + i);
            bookInfo.setStatus(i%3==0?2:1);
            bookInfos.add(bookInfo);
        }
        return bookInfos;
    }
}
