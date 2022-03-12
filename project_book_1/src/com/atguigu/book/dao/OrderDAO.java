package com.atguigu.book.dao;

import com.atguigu.book.pojo.OrderBean;
import com.atguigu.book.pojo.User;

import java.util.List;

/**
 * @author zhanghu
 * @create 2022-03-01 11:26
 */
public interface OrderDAO {
    /***
     * 添加订单
     * @param orderBean
     */
    void  addOrderBean(OrderBean orderBean);
    List<OrderBean> getOrderList(User user);
    Integer getOrderTotalBookCount(OrderBean orderBean);
}
