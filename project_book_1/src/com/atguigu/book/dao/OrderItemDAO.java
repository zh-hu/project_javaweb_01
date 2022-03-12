package com.atguigu.book.dao;

import com.atguigu.book.pojo.OrderItem;

/**
 * @author zhanghu
 * @create 2022-03-01 11:28
 */
public interface OrderItemDAO {
    /**
     * 添加订单项
     * @param orderItem
     */
    void addOrderItem(OrderItem orderItem);
}
