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

@WebServlet(value = "/AddCartServlet")
public class AddCartServlet extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        String gid = request.getParameter("gid");
        String gcount = request.getParameter("gcount");
        if (gid != null && gcount != null) {
            Goods goods = new Goods();
            GoodsDao goodsDao = new GoodsDao();
            goods = goodsDao.setGoods(Integer.parseInt(gid));
            goods.setGcount(Integer.parseInt(gcount));
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart != null) {
                cart.addGoods(goods);
            } else {
                cart = new Cart();
                cart.addGoods(goods);
            }
            session.setAttribute("cart", cart);
            response.getWriter().println("添加成功");
            response.getWriter().println("<a href='cart.jsp'>查看购物车</a>");
            response.getWriter().println("<a href='javascript:history.go(-1)'>返回上一页</a>");
        } else {
            response.getWriter().println("参数错误");
            response.getWriter().println("<a href='javascript:history.go(-1)'>返回上一页</a>");
        }
    }
}
