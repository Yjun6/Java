package com.example.book.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-03
 * Time:18:34
 */
@Data
public class BookInfo {
    private Integer id;
    private String bookName;
    private String author;
    private Integer count;
    private BigDecimal price;//保证精度
    private String publish;
    private Integer status;//1 - 可借阅  其他数是不可借阅
    private String statusCN; // 状态的中文
}
