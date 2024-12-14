package com.example.jspsevletecerc07;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author uncle_yumo
 * @fileName EncodingServlet
 * @createDate 2024/12/14 December
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@WebServlet("/EncodingServlet")
public class EncodingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(this.getClass().getName() + "EncodingServlet doGet method called");
        String param = req.getParameter("param");
        if (param != null) {
            System.out.println(this.getClass().getName() + "Parameter found: " + param);
            req.getSession().setAttribute("param", param);
            resp.sendRedirect("showparam.jsp");
        } else {
            System.out.println(this.getClass().getName() + "No parameter found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}