package com.atguig.fruit.service;

import com.atguig.fruit.pojo.Fruit;

import java.util.List;

/**
 * @author zhanghu
 * @create 2022-02-16 13:19
 */
public interface FruitService {

    //获取指定页面的库存信息
    List<Fruit> getFruitList(String keyword,Integer pageNo);
    //添加库存信息记录
    void  addFruit(Fruit fruit);
    //根据id查看制定的库存记录
    Fruit getFruitByFid(Integer fid);
    //删除特定的库存记录
    void delFruit(Integer fid);
    //获取总页数
    Integer getPageCount(String keyword);
    //修改特定库存记录
    void updateFruit(Fruit fruit);
}
