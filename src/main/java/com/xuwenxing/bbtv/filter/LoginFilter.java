package com.xuwenxing.bbtv.filter;

import com.google.gson.Gson;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by xuwx on 2018/9/5.
 */
@Order(1)//表示执行过滤顺序 值
@WebFilter(filterName = "loginFilter")
public class LoginFilter implements Filter{



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request =(HttpServletRequest)servletRequest;
        HttpServletResponse response =(HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        /**
          * 在Spring Security中，用户信息保存在SecurityContextHolder中。Spring Security使用一个Authentication对象来持有所有系统的安全认证相关的信息
          */
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("loginFilter:"+new Gson().toJson(principal));
        String username=principal.toString();
        session.setAttribute("username",username);
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
