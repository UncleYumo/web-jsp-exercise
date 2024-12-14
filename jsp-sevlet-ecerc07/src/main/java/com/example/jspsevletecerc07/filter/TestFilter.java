package com.example.jspsevletecerc07.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author uncle_yumo
 * @fileName TestFilter
 * @createDate 2024/12/14 December
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public class TestFilter  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(this.getClass().getName() + "过滤器初始化函数运行");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(this.getClass().getName() + "对请求进行过滤处理");
        servletRequest.setCharacterEncoding("UTF-8");

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        HttpSession session = httpRequest.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            System.out.println("用户未登录，设置 Refresh 头");
            httpResponse.setHeader("Content-Type", "text/html;charset=UTF-8");
            httpResponse.getWriter().append("你还没有登录，5秒后自动跳转到登录页面");
            httpResponse.setHeader("Refresh", "5;URL=../login.html");
            System.out.println("Refresh 头设置完毕");
        } else {
            System.out.println("用户已登录，继续过滤链");
            filterChain.doFilter(servletRequest, servletResponse);
        }

        servletResponse.setCharacterEncoding("UTF-8");
        System.out.println(this.getClass().getName() + "执行 chain.doFilter() 方法后面的代码");
    }

    @Override
    public void destroy() {
        System.out.println(this.getClass().getName() + "过滤器消亡函数运行");
    }
}
