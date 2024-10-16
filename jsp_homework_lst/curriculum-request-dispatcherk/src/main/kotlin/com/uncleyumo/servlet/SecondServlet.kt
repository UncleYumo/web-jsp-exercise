package com.uncleyumo.servlet

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

/**
 *@author uncle_yumo
 *@fileName SecondServlet
 *@proName jsp_homework_lst
 *@school Wuxi_University
 *@stuNumber 22344131
 *@createTime 2024/10/14
 *@updateTime 2024/10/14
 *@description
 **/

@WebServlet("/secondServlet")
class SecondServlet : HttpServlet() {
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        if (req == null || resp == null) { return println("req or resp is null") }
        val username = req.getParameter("username")
        val password = req.getParameter("password")
        val message = req.getParameter("message")
        val num = req.getParameter("num")
        val out = resp.writer
        out.println("${this.javaClass.name}接收转发请求<br>")
        out.println("接收表单的参数<br>")
        out.println("姓名 | $username<br>密码 | $password<br>消息 | $message<br>数字 | $num")
    }

    override fun doPost(
        req: HttpServletRequest?,
        resp: HttpServletResponse?
    ) {
        doGet(req, resp)
    }
}