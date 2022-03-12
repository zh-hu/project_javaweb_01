package com.atguig.demo;

import javax.servlet.ServletContext;
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
@WebServlet("/demo06")
public class Demo06Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.service(req, resp);
        //获取application保存作用域保存的数据 key为name
        ServletContext application = request.getServletContext();
        Object unmaeObj = application.getAttribute("uname");
        System.out.println("unameObj"+unmaeObj);

    }
}
