package com.atguig.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhanghu
 * @create 2022-02-14 15:29
 */
@WebServlet("/demo03")
public class Demo03Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.service(request, response);
        //1向request保存作用域保存数据域
        request.getSession().setAttribute("uname","lili");

        //2客户端重定向
        response.sendRedirect("demo04");

        //3服务器端转发
        //request.getRequestDispatcher("demo02").forward(request,response);
    }
}
