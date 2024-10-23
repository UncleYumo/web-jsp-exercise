package com.example.jsp_servlet_exerc03

import com.example.bean.Cart
import com.example.bean.Goods
import com.example.dao.GoodsDao
import jakarta.servlet.http.*
import jakarta.servlet.annotation.*

@WebServlet("/AddCartServlet")
class AddCartServlet : HttpServlet() {
    private lateinit var message: String

    override fun init() {
        message = "This is the AddCartServlet"
    }

    public override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        response.apply {
            characterEncoding = "UTF-8"
            setHeader("Content-Type", "text/html; charset=UTF-8")
        }
        val gid: String? = request.getParameter("gid")
        val gcount: String? = request.getParameter("gcount")

        if (gid != null && gcount != null) { // 更正逻辑条件，确保同时存在 gid 和 gcount
            val goodsDao: GoodsDao = GoodsDao()
            val goods: Goods = goodsDao.setGoods(Integer.parseInt(gid))
            goods.setGcount(Integer.parseInt(gcount))
            val session: HttpSession = request.session
            var cart: Cart? = session.getAttribute("cart") as Cart?

            if (cart == null) {
                cart = Cart() // 如果 cart 为空则创建新的 Cart 实例
            }
            cart.addGoods(goods)
            session.setAttribute("cart", cart)

            response.writer.apply {
                println("添加成功")
                println("<a href='cart.jsp'>查看购物车</a>")
                println("<a href='javascript:history.go(-1)'>返回上一页</a>")
            }
        } else {
            response.writer.apply {
                println("参数错误")
                println("<a href='javascript:history.go(-1)'>返回上一页</a>")
            }
        }
    }

    override fun destroy() {
    }
}