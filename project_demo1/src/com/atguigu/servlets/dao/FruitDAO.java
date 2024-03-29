package com.atguigu.servlets.dao;

import com.atguigu.servlets.pojo.Fruit;

import java.util.List;

/**
 * @author zhanghu
 * @create 2022-02-12 16:23
 */
public interface  FruitDAO {
    //查询库存列表
    List<Fruit> getFruitList();

    //新增库存
    boolean addFruit(Fruit fruit);

    //修改库存
    boolean updateFruit(Fruit fruit);

    //根据名称查询特定库存
    Fruit getFruitByFname(String fname);

    //删除特定库存记录
    boolean delFruit(String fname);
}
