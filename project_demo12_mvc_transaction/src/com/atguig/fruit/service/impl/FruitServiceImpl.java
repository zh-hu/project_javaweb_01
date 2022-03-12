package com.atguig.fruit.service.impl;

import com.atguig.fruit.service.FruitService;
import com.atguig.fruit.dao.FruitDAO;
import com.atguig.fruit.dao.impl.FruitDAOImpl;
import com.atguig.fruit.pojo.Fruit;
import com.atguigu.myssm.basedao.ConnUtil;

import java.util.List;

/**
 * @author zhanghu
 * @create 2022-02-16 13:23
 */
public class FruitServiceImpl implements FruitService {
    private FruitDAO fruitDAO = null ;

    @Override
    public List<Fruit> getFruitList(String keyword, Integer pageNo) {
        System.out.println("getFruitList -> "+ConnUtil.getConn());
        return fruitDAO.getFruitList(keyword,pageNo);
    }

    @Override
    public void addFruit(Fruit fruit) {
        fruitDAO.addFruit(fruit);
        Fruit fruit1 = fruitDAO.getFruitByFid(2);
        fruit1.setFcount(99);
        fruitDAO.updateFruit(fruit1);

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
        System.out.println("getFruitList -> "+ConnUtil.getConn());
        int count = fruitDAO.getFruitCount(keyword);
        int pageCount = (count+5-1)/5 ;
        return pageCount;
    }

    @Override
    public void updateFruit(Fruit fruit) {
        fruitDAO.updateFruit(fruit);
    }
}
