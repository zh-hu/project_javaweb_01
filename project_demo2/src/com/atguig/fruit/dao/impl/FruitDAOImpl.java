package com.atguig.fruit.dao.impl;

import com.atguig.fruit.dao.FruitDAO;
import com.atguig.fruit.pojo.Fruit;
import com.atguigu.myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @author zhanghu
 * @create 2022-02-13 22:35
 */
public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {
    @Override
    public List<Fruit> getFruitList() {
        return super.executeQuery("select * from t_fruit");
    }
}
