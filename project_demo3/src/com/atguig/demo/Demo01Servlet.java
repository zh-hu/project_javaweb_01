package com.atguig.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhanghu
 * @create 2022-02-14 15:03
 */
//演示request保存作用域（demo01和demo02）
@WebServlet("/demo01")
public class Demo01Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.service(request, response);
        //1向request保存作用域保存数据域
        request.setAttribute("uname","lili");
        //客户端重定向
        //response.sendRedirect("demo02");
        //3服务器端转发
        request.getRequestDispatcher("demo02").forward(request,response);
    }
}
