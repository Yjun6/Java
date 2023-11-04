package com.example.book.service;

import com.example.book.dao.BookDao;
import com.example.book.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-03
 * Time:20:00
 */
@Component
public class BookService {
    @Autowired
    private BookDao bookDao;

    public List<BookInfo> getBookList() {
        List<BookInfo> bookInfos = bookDao.mockData();
        for (BookInfo bookInfo : bookInfos) {
            if (bookInfo.getStatus() == 1) {
                bookInfo.setStatusCN("可借阅");
            } else {
                bookInfo.setStatusCN("不可借阅");
            }
        }
        return bookInfos;
    }
}
