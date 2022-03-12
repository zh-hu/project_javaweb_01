package com.atguigu.book.service;

import com.atguigu.book.pojo.OrderBean;
import com.atguigu.book.pojo.User;

import java.util.List;

/**
 * @author zhanghu
 * @create 2022-03-01 11:39
 */
public interface OrderService {

    void addOrderBean(OrderBean orderBean);
    List<OrderBean> getOrderList(User user);
}
