package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author uncle_yumo
 * @fileName StuRegisterServlet
 * @createDate 2024/10/9 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@WebServlet("/stuRegister")
public class StuRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        resp.getWriter().println("<div style='text-align:center;margin-top:100px;'>");
        resp.getWriter().println("注册成功！<br>");
        resp.getWriter().println("姓名：" + name + "<br>");
        resp.getWriter().println("密码：" + password + "<br>");
        resp.getWriter().println("邮箱：" + email + "<br>");
        resp.getWriter().println("</div>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
