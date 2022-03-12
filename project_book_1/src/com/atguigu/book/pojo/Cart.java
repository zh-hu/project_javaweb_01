package com.atguigu.book.pojo;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

/**
 * @author zhanghu
 * @create 2022-02-28 12:11
 */
public class Cart {
    /**
     * 购物车中购物车项的总金额,这个map集合的key时book的id
     */
    private Map<Integer,CartItem > cartItemMap;
    /**
     * 购物车的总金额
     */
    private Double totalMoney;
    /**
     * 购物车书的数量
     */
    private Integer totalCount;

    /**
     * 购物车中书本的总数量
     */
    private Integer totalBookCount;

    public Cart() {
    }

    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Double getTotalMoney() {
        // 1.声明一个变量用于存储累加结果
        BigDecimal sum = new BigDecimal("0.0");

        // 2.遍历Map集合
        Set<Integer> keySet = cartItemMap.keySet();

        for (Integer key : keySet) {
            CartItem cartItem = cartItemMap.get(key);
            Double amount = cartItem.getXj();

            sum = sum.add(new BigDecimal(amount + ""));
        }

        totalMoney=sum.doubleValue();

        // 3.返回累加结果
        return totalMoney;

    }



    public Integer getTotalCount() {
        totalCount = 0 ;
        if(cartItemMap!=null && cartItemMap.size()>0){
            totalCount = cartItemMap.size() ;
        }
        return totalCount;
    }

    public Integer getTotalBookCount() {
        totalBookCount = 0 ;
        if(cartItemMap!=null && cartItemMap.size()>0){
            for (CartItem cartItem : cartItemMap.values()){
                totalBookCount = totalBookCount + cartItem.getBuyCount() ;
            }
        }
        return totalBookCount;
    }

    public void setTotalBookCount(Integer totalBookCount) {
        this.totalBookCount = totalBookCount;
    }
}
