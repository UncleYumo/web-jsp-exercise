package com.uncleyumo.servlet

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import jakarta.servlet.http.HttpSession

/**
 * @author uncle_yumo
 * @fileName WelcomeServlet
 * @createDate 2024/10/16 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@WebServlet("/WelcomeServlet")
class WelcomeServlet : HttpServlet() {
    override fun doGet(request: HttpServletRequest?, response: HttpServletResponse?) {
        response?.apply {
            characterEncoding = "UTF-8"
            setHeader("Content-Type", "text/html;charset=UTF-8")
        }
        val session: HttpSession? = request?.getSession(false)
        if (session != null) {
            val username: String = session.getAttribute("username") as String
            if (username != null) {
                response?.writer?.append("欢迎 $username 登录！")?.append(
                    "<a href='LogoutServlet'>退出登录</a>"
                )

            } else {
                response?.apply {
                    writer?.append("请先登录！5秒后自动跳转到登录页面...")
                    setHeader("Refresh", "5;url=login.html")
                }
            }
        } else {
            response?.apply {
                writer?.append("禁止直接访问！5秒后自动跳转到登录页面...")
                setHeader("Refresh", "5;url=login.html")
            }
        }
    }

    override fun doPost(request: HttpServletRequest?, response: HttpServletResponse?) {
        doGet(request, response)
    }
}