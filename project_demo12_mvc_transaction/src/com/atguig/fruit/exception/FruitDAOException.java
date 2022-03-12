package com.atguig.fruit.exception;

/**
 * @author zhanghu
 * @create 2022-02-17 15:48
 */
public class FruitDAOException extends RuntimeException{
    public FruitDAOException(String msg){
        super(msg);
    }
}
