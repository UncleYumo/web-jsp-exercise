package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author uncle_yumo
 * @CreateDate 2024/9/25
 * @School 无锡学院
 * @StudentID 22344131
 * @Description
 */

@WebServlet("/loginSuccess")
public class LoginSuccessServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理登录成功的逻辑
        // 跳转到登录成功页面
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<div style='text-align:center;margin-top:100px;'>");
        out.println("<h1>登录成功！</h1>");
        out.println("<a href='login.jsp'>返回登录页面</a>");
        out.println("</div>");
        out.println("</body></html>");
    }
}
