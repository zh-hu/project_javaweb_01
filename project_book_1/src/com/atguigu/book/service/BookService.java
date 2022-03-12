package com.atguigu.book.service;

import com.atguigu.book.pojo.Book;

import java.util.List;

/**
 * @author zhanghu
 * @create 2022-02-28 11:02
 */
public interface BookService {
    /**
     *
     * @return
     */
    List<Book> getBookList();

    Book getBook(Integer id);
}
