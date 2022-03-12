package com.atguig.fruit.servlets;

import com.atguig.fruit.dao.FruitDAO;
import com.atguig.fruit.dao.impl.FruitDAOImpl;
import com.atguig.fruit.pojo.Fruit;
import com.atguigu.myssm.myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author zhanghu
 * @create 2022-02-13 22:39
 */
//servlet从3.0版本开始支持注解方式的注册
@WebServlet("/index")
public class indexServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FruitDAO fruitDAO = new FruitDAOImpl();
        List<Fruit> fruitList = fruitDAO.getFruitList();
        //保留到session作用域
        HttpSession session = request.getSession();
        session.setAttribute("fruitList",fruitList);
        //此处视图名称是index
        //那么thymeleaf会将这个逻辑视图名称对应到物理视图名称上
        //逻辑视图名称： index
        //物理视图名称： view-prefix +逻辑视图名称+view-suffix
        //所以正式的视图名称是： /  index  .html
        super.processTemplate("index",request,response);

    }
}
