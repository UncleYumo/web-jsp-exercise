package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        System.out.println("RegisterServlet的doGet方法被调用了");
        response.setHeader("Access-Control-Allow-Origin", "*"); // 允许所有来源

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username == null || password == null) {
            PrintWriter out = response.getWriter();
            out.println("Username or password is null!");
            out.flush();
            out.close();
            return; // 退出方法，避免后续代码执行
        }

        // 进行注册逻辑，比如简单的匹配
        if (username.equals("admin") && password.equals("123456")) {
            PrintWriter out = response.getWriter();
            out.println("Successfully registered!");
            System.out.printf("用户名：%s，密码：%s\n", username, password);
            out.flush();
            out.close();
        } else {
            PrintWriter out = response.getWriter();
            out.println("Failed to register!");
            out.flush();
            out.close();
        }
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        System.out.println("RegisterServlet的doPost方法被调用了");
        response.setHeader("Access-Control-Allow-Origin", "*"); // 允许所有来源

        String requestInfo = request.getReader().readLine();
        System.out.println(requestInfo);

        // username=admin&password=123456
        String[] params = requestInfo.split("&");
        String[] usernameAndPassword = params[0].split("=");
        String[] passwordAndUsername = params[1].split("=");

        String username = usernameAndPassword[1];
        String password = passwordAndUsername[1];

        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);

        // 检查用户名和密码是否为 null
        if (username == null || password == null) {
            PrintWriter out = response.getWriter();
            out.println("Username or password is null!");
            out.flush();
            out.close();
            return; // 退出方法，避免后续代码执行
        }

        // 进行注册逻辑，比如简单的匹配
        if (username.equals("admin") && password.equals("123456")) {
            PrintWriter out = response.getWriter();
            out.println(
//                    "1|/static/register_success.html"
                    "1|http://localhost:8080/jsp_servlet_exerc01/loginSuccess"
            );
            System.out.printf("用户名：%s，密码：%s\n", username, password);
            out.flush();
            out.close();

        } else {
            PrintWriter out = response.getWriter();
            out.println(
                    "0|http://localhost:8080/jsp_servlet_exerc01/loginFailed"
            );
            out.flush();
            out.close();
        }
    }
}
