package com.atguigu.book.controller;

import com.atguigu.book.pojo.Book;
import com.atguigu.book.service.BookService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zhanghu
 * @create 2022-02-28 11:18
 */
public class BookController {

    private BookService bookService;
    public String index(HttpSession session){
        List<Book> bookList = bookService.getBookList();
        session.setAttribute("bookList",bookList);
        return "index";
    }
}
