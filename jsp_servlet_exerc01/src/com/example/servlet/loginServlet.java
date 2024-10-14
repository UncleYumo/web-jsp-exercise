package com.example.servlet;

// 过滤Wrong tag提示

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author uncle_yumo
 * @CreateDate 2024/9/24
 * @School 无锡学院
 * @StudentID 22344131
 * @Description
 */

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("pwd");
        if ("admin".equals(username) && "admin".equals(password)) {
            // 重定向到登录成功页面
            resp.sendRedirect("exerc2/login_success.html");
        } else {
            // 重定向到登录失败页面
            resp.sendRedirect("exerc2/login_failed.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);

    }
}