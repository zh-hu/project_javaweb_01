package com.atguigu.book.service;

import com.atguigu.book.pojo.Cart;
import com.atguigu.book.pojo.CartItem;
import com.atguigu.book.pojo.User;

import java.util.List;

/**
 * @author zhanghu
 * @create 2022-02-28 12:07
 */
public interface CartItemService {
    void addCartItem(CartItem cartItem);
    void updateCartItem(CartItem cartItem);
    void addOrUpdateCartItem(CartItem cartItem, Cart cart);

    /**
     * 获取指定用户的所有购物车列表(需要注意的是，这个方法内部查询的时候，会将book的详细信息设置进去)
     * @param user
     * @return
     */

    List<CartItem> getCartItemList(User user);

    /**
     * 加载特定用户的购物车信息
     * @param user
     * @return
     */
    Cart getCart(User user);
}
