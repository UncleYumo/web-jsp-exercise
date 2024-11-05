package cn.uncleyumo.shoppingcart.servlet;

import cn.uncleyumo.shoppingcart.bean.Cart;
import cn.uncleyumo.shoppingcart.bean.Goods;
import cn.uncleyumo.shoppingcart.dao.GoodsDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author uncle_yumo
 * @fileName AddCartServlet
 * @createDate 2024/11/5 November
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@WebServlet(value = "/DeleteCartServlet")
public class DeleteCartServlet extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        String gid = request.getParameter("gid");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.deleteGoods(Integer.parseInt(gid));
        response.getWriter().println("删除成功！！！！！");
        response.getWriter().println("<a href='javascript:history.go(-1)'>返回上一页</a>");
    }
}
