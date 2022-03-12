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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author zhanghu
 * @create 2022-02-15 15:14
 */
@WebServlet("/fruit.do")
public class FruitServlet extends ViewBaseServlet {

    private FruitDAO fruitDAO = new FruitDAOImpl();



    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("UTF-8");
        String operate = request.getParameter("operate");
        if(StringUtil.isEmpty(operate)){
            operate="index";
        }
        //获取当前类的所有方法
        Method[] methods = this.getClass().getDeclaredMethods();
        for(Method m : methods){
            //获取方法名
            String methodName = m.getName();
            if(operate.equals(methodName)){
                //找到和operate同名的方法名，通过反射技术调用它

                try {
                    m.invoke(this,request,response);
                    return;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        throw  new RuntimeException("operate值非法");

    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取参数
        String fidStr = request.getParameter("fid");
        int fid = Integer.parseInt(fidStr);
        String fname = request.getParameter("fname");
        String priceStr = request.getParameter("price");
        int price = Integer.parseInt(priceStr);
        String fcountStr = request.getParameter("fcount");
        int fcount = Integer.parseInt(fcountStr);
        String remark = request.getParameter("remark");
        //执行更新
        fruitDAO.updateFruit(new Fruit(fid,fname,price,fcount,remark));
        //资源跳转
        // super.processTemplate("index",request,response);
        //request.getRequestDispatcher("index.html").forward(request,response);
        //此处需要重定向，目的是从新给indexServlet发请求，重新获取fruitList,然后覆盖到session中这样index.html页面上显示的session数据才是最新的
        response.sendRedirect("fruit.do");
    }

    protected void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fidStr = request.getParameter("fid");
        if(StringUtil.isNotEmpty(fidStr)){
            int fid = Integer.parseInt(fidStr);
            fruitDAO.delFruit(fid);
            response.sendRedirect("fruit.do");
        }
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fidStr = request.getParameter("fid");
        if(StringUtil.isNotEmpty(fidStr)){
            int fid = Integer.parseInt(fidStr);
            Fruit fruit = fruitDAO.getFruitByFid(fid);
            request.setAttribute("fruit",fruit);
            super.processTemplate("edit",request,response);
        }
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取参数
        String fname = request.getParameter("fname");
        String priceStr = request.getParameter("price");
        int price = Integer.parseInt(priceStr);
        String fcountStr = request.getParameter("fcount");
        int fcount = Integer.parseInt(fcountStr);
        String remark = request.getParameter("remark");

        Fruit fruit =new Fruit(0,fname,price,fcount,remark);
        fruitDAO.addFruit(fruit);
        response.sendRedirect("fruit.do");
    }

    private void index(HttpServletRequest request , HttpServletResponse response)throws IOException, ServletException {


        HttpSession session = request.getSession() ;
        Integer pageNo = 1 ;

        String oper = request.getParameter("oper");
        //如果oper!=null 说明 通过表单的查询按钮点击过来的
        //如果oper是空的，说明 不是通过表单的查询按钮点击过来的

        String keyword = null ;
        if(StringUtil.isNotEmpty(oper) && "search".equals(oper)){
            //说明是点击表单查询发送过来的请求
            //此时，pageNo应该还原为1 ， keyword应该从请求参数中获取
            pageNo = 1 ;
            keyword = request.getParameter("keyword");
            //如果keyword为null，需要设置为空字符串“ ”，否则查询时会拼接成%null%，我们希望的是%%
            if(StringUtil.isEmpty(keyword)){
                keyword = "" ;
            }
            //将keyword保存（覆盖）到session上
            session.setAttribute("keyword",keyword);
        }else{
            //说明此处不是点击表单查询发送过来的请求（比如点击下面的上一页下一页或者直接在地址栏输入网址）
            //此时keyword应该从session作用域获取
            String pageNoStr = request.getParameter("pageNo");
            if(StringUtil.isNotEmpty(pageNoStr)){
                pageNo = Integer.parseInt(pageNoStr);
            }

            //如果不是点击的查询按钮，那么查询时基于session中保存的现有的keyword进行查询
            Object keywordObj = session.getAttribute("keyword");
            if(keywordObj!=null){
                keyword = (String)keywordObj ;
            }else{
                keyword = "" ;
            }
        }


        session.setAttribute("pageNo",pageNo);

        FruitDAO fruitDAO = new FruitDAOImpl();
        List<Fruit> fruitList = fruitDAO.getFruitList(keyword,pageNo);
        //保留到session作用域
        session.setAttribute("fruitList",fruitList);

        //总记录条数
        int fruitCount = fruitDAO.getFruitCount(keyword);
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
