package com.uncleyumo.servlet

import jakarta.servlet.RequestDispatcher
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import java.io.PrintWriter

/**
 *@author uncle_yumo
 *@fileName FirstServlet
 *@proName jsp_homework_lst
 *@school Wuxi_University
 *@stuNumber 22344131
 *@createTime 2024/10/14
 *@updateTime 2024/10/14
 *@description
 **/

@WebServlet("/firstServlet")
class FirstServlet : HttpServlet() {

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        if (req == null || resp == null) { return println("req or resp is null") }
        req.characterEncoding = "UTF-8"
        resp.characterEncoding = "UTF-8"
        resp.setHeader("Content-Type", "text/html;charset=UTF-8")
        var message: String = "UnKnown Country"
        val out: PrintWriter = resp.writer
        when (req.getParameter("country")) {
            "中国" -> message = "这是一个中国的用户"
            "美国" -> message = "这是一个美国的用户"
            "英国" -> message = "这是一个英国的用户"
        }
        req.setAttribute("message", message)
        out.println("${this.javaClass.name}请求已经处理完成，可以转发")
        val rd: RequestDispatcher = req.getRequestDispatcher("secondServlet")
        rd.forward(req, resp)
        req.setAttribute("num", 1)
        out.println("${this.javaClass.name}请求已经被转发到")
    }

    override fun doPost(
        req: HttpServletRequest?,
        resp: HttpServletResponse?
    ) {
        doGet(req, resp)
    }
}