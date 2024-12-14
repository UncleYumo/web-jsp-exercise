package com.example.jspsevletecerc07;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author uncle_yumo
 * @fileName LoginServlet
 * @createDate 2024/12/14 December
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(this.getClass().getName() + "用户名：" + username + "，密码：" + password);

        if (username != null || password != null) {
            if (username.equals(password)) {
                request.getSession().setAttribute("username", username);
                response.sendRedirect("user/index.jsp");
            } else {
                System.out.println(this.getClass().getName() + "用户名或密码错误！");
            }
        } else {
            System.out.println(this.getClass().getName() + "用户名或密码为空！");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
