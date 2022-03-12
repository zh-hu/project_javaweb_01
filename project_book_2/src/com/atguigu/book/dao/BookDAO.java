package com.atguigu.book.dao;

import com.atguigu.book.pojo.Book;

import java.util.List;

/**
 * @author zhanghu
 * @create 2022-02-28 10:59
 */
public interface BookDAO {
    /**
     *
     * @return
     */
    List<Book> getBookList();

    Book getBook(Integer id);
}
