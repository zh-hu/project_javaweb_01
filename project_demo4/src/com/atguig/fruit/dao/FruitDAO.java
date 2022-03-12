package com.atguig.fruit.dao;



import com.atguig.fruit.pojo.Fruit;

import java.util.List;

public interface FruitDAO {
    //获取指定页码上的所有的库存列表信息,每页显示5条
    List<Fruit> getFruitList(Integer pageNo);

    //根据fid获取特定的水果库存信息
    Fruit getFruitByFid(Integer fid);

    //修改制定的库存记录
    void updateFruit(Fruit fruit);

    //根据fid删除制定的库存记录
    void delFruit(Integer fid);

    //添加新库存记录
    void addFruit(Fruit fruit);

    //查询库存总记录条数
    int getFruitCount();
}
