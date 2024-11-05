package com.example.jsp_servlet_exerc03;

import com.example.bean.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author uncle_yumo
 * @fileName DeleteCartServlet
 * @createDate 2024/11/5 November
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@WebServlet("/deleteCart")
public class DeleteCartServlet extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
    }
}
