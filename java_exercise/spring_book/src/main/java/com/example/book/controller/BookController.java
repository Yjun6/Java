package com.example.book.controller;

import com.example.book.model.BookInfo;
import com.example.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-03
 * Time:18:33
 */
@RequestMapping("/book")
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/getBookList")
    public List<BookInfo> getBookList() {
        //1.获取图书数据
        //2.对图书数据的处理
        //3.返回数据
        //mock表示虚拟的，假数据
        List<BookInfo> bookInfos = bookService.getBookList();
        return bookInfos;
    }

}
