package com.atguig.fruit.servlets;

import com.atguig.fruit.dao.FruitDAO;
import com.atguig.fruit.dao.impl.FruitDAOImpl;
import com.atguig.fruit.pojo.Fruit;
import com.atguigu.myssm.myspringmvc.ViewBaseServlet;
import com.atguigu.myssm.util.StringUtil;

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
        Integer pageNo = 1 ;
        String pageNoStr = request.getParameter("pageNo");
        if(StringUtil.isNotEmpty(pageNoStr)){
            pageNo = Integer.parseInt(pageNoStr);
        }

        HttpSession session = request.getSession() ;
        session.setAttribute("pageNo",pageNo);

        FruitDAO fruitDAO = new FruitDAOImpl();
        List<Fruit> fruitList = fruitDAO.getFruitList(pageNo);
        //保留到session作用域
        session.setAttribute("fruitList",fruitList);

        //总记录条数
        int fruitCount = fruitDAO.getFruitCount();
        //总页数
        int pageCount = (fruitCount+5-1)/5 ;

         /*
        总记录条数       总页数
        1               1
        5               1
        6               2
        10              2
        11              3
        fruitCount      (fruitCount+5-1)/5
         */
        session.setAttribute("pageCount",pageCount);


        //此处视图名称是index
        //那么thymeleaf会将这个逻辑视图名称对应到物理视图名称上
        //逻辑视图名称： index
        //物理视图名称： view-prefix +逻辑视图名称+view-suffix
        //所以正式的视图名称是： /  index  .html
        super.processTemplate("index",request,response);

    }
}
