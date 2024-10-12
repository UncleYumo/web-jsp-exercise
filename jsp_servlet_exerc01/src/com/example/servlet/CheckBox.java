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
 * @CreateDate 2024/9/26
 * @School 无锡学院
 * @StudentID 22344131
 * @Description
 */

@WebServlet("/CheckBox")
public class CheckBox extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        System.out.println("Call of doGet()");
        response.setContentType("text/html;charset=UTF-8");  // 设置响应内容类型，编码格式
        PrintWriter out = response.getWriter();  // 获取 PrintWriter 对象
        String title = "读取复选框数据";
        String docType = "<!DOCTYPE html>\n";
        out.println(
                docType +
                        "<html>\n" +
                        "<head><title>" + title + "</title></head>\n" +
                        "<body bgcolor=\"#f0f0f0\">\n" +
                        "<h1 align=\"center\">" + title + "</h1>\n" +
                        "<h1 align=\"center\">" + title + "</h1>\n" +
                        "  <li><b>JSP按教程标识：</b>: "
                        + request.getParameter("runoob") + "\n" +
                        "  <li><b>Google 标识：</b>: "
                        + request.getParameter("google") + "\n" +
                        "  <li><b>淘宝标识：</b>: "
                        + request.getParameter("taobao") + "\n" +
                        "</ul>\n" +
                        "</body></html>"
        );
    }

    @Override
    protected void doPost(
            HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        System.out.println("Call of doPost()");
        doGet(request, response);
    }
}
