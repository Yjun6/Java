package com.example.book.service;

import com.example.book.dao.BookDao;
import com.example.book.model.BookInfo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-03
 * Time:20:00
 */
public class BookService {
    private BookDao bookDao = new BookDao();
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
