package com.atguigu.book.dao;

import com.atguigu.book.pojo.User;

/**
 * @author zhanghu
 * @create 2022-02-27 22:08
 */
public interface UserDAO {
    User getUser(String uname , String pwd);
    void addUser(User user);
    User getUser(String uname);
}
