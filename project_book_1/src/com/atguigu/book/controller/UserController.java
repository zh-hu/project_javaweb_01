package com.atguigu.book.controller;

import com.atguigu.book.pojo.Cart;
import com.atguigu.book.pojo.User;
import com.atguigu.book.service.CartItemService;
import com.atguigu.book.service.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author zhanghu
 * @create 2022-02-27 22:07
 */
public class UserController {

    private UserService userService;
    private CartItemService cartItemService;


    public String login(String uname, String pwd, HttpSession session){

        User user = userService.login(uname,pwd);
        if(user!=null){
            Cart cart = cartItemService.getCart(user);
            user.setCart(cart);
            session.setAttribute("currUser",user);
            return "redirect:book.do";
        }

        return "user/login";
    }

    public String regist(String verifyCode, String uname, String pwd, String email, HttpSession session, HttpServletResponse response) throws IOException {
        Object kaptchaCodekey = session.getAttribute("KAPTCHA_SESSION_KEY");
        if(kaptchaCodekey==null || !verifyCode.equals(kaptchaCodekey)){
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script language='JavaScript'>alert('验证码不正确！');</script>");

            //return "user/regist";
            return "user/regist";
        }else {
            if(verifyCode.equals(kaptchaCodekey)){
                userService.regist(new User(uname,pwd,email,0));
                return "user/login";
            }
        }
        return "user/login";

    }
    public String ckUname(String uname){
        User user = userService.getUser(uname);
        if(user!=null){
            //用户已经被占用，不可以注册
            return "json:{'uname':'1'}";
            //return "ajax:1";
        }else {
            //用户名可以被注册
            // return "ajax:0";
            return "json:{'uname':'0'}";
        }
    }
}
