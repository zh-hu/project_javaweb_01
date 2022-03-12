package com.atguigu.book.dao;

import com.atguigu.book.pojo.CartItem;
import com.atguigu.book.pojo.User;

import java.util.List;

/**
 * @author zhanghu
 * @create 2022-02-28 11:59
 */
public interface CartItemDAO {
    /**
     * 新增购物车项
     * @param cartItem
     */
    void addCartItem(CartItem cartItem);

    /**
     * 修改特定的购物车项
     * @param cartItem
     */
    void updateCartItem(CartItem cartItem);

    /**
     * 获取特定用户的所有购物车项
     * @param user
     * @return
     */

    List<CartItem> getCartItemList(User user);

    /**
     * 删除特定的购物车项
     * @param cartItem
     */
    void delCartItem(CartItem cartItem);
}
