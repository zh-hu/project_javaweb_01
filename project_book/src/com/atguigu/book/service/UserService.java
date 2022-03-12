package com.atguigu.book.service;

import com.atguigu.book.pojo.User;

/**
 * @author zhanghu
 * @create 2022-02-27 22:12
 */
public interface UserService {
    User login(String uname,String pwd);
}
