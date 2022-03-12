package com.atguig.fruit.service.impl;

import com.atguig.fruit.service.FruitService;
import com.atguig.fruit.dao.FruitDAO;
import com.atguig.fruit.dao.impl.FruitDAOImpl;
import com.atguig.fruit.pojo.Fruit;

import java.util.List;

/**
 * @author zhanghu
 * @create 2022-02-16 13:23
 */
public class FruitServiceImpl implements FruitService {
    private FruitDAO fruitDAO = null ;

    @Override
    public List<Fruit> getFruitList(String keyword, Integer pageNo) {
        return fruitDAO.getFruitList(keyword,pageNo);
    }

    @Override
    public void addFruit(Fruit fruit) {
        fruitDAO.addFruit(fruit);
    }

    @Override
    public Fruit getFruitByFid(Integer fid) {
        return fruitDAO.getFruitByFid(fid);
    }

    @Override
    public void delFruit(Integer fid) {
        fruitDAO.delFruit(fid);
    }

    @Override
    public Integer getPageCount(String keyword) {
        int count = fruitDAO.getFruitCount(keyword);
        int pageCount = (count+5-1)/5 ;
        return pageCount;
    }

    @Override
    public void updateFruit(Fruit fruit) {
        fruitDAO.updateFruit(fruit);
    }
}
