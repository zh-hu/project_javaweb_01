package com.atguigu.myssm.filters;

import com.atguigu.myssm.trans.TransactionManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author zhanghu
 * @create 2022-02-17 14:10
 */
@WebFilter("*.do")
public class OpenSessionInViewFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try{
            TransactionManager.beginTrans();
            System.out.println("开启事务");
            filterChain.doFilter(servletRequest,servletResponse);
            TransactionManager.commit();
            System.out.println("提交事务");
        }catch (Exception e){
            e.printStackTrace();
            try {
                TransactionManager.rollback();
                System.out.println("回滚事务");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {

    }
}
