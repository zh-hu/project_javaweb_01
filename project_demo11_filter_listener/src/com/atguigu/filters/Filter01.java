package com.atguigu.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author zhanghu
 * @create 2022-02-16 20:50
 */
// @WebServlet("/demo01.do")
@WebFilter("*.do")
public class Filter01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("A");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("A2");
    }

    @Override
    public void destroy() {

    }
}
