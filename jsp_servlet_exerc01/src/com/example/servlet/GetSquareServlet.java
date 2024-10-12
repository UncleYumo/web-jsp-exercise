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
 * @CreateDate 2024/9/24
 * @School 无锡学院
 * @StudentID 22344131
 * @Description
 */

@WebServlet("/getSquare")
public class GetSquareServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        int num = Integer.parseInt(request.getParameter("num"));
        int square = num * num;
        PrintWriter out = response.getWriter();
        out.println("This is the result of GetSquareServlet\n");
        out.println("The square of " + num + " is " + square);
    }
}
