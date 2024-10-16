package com.uncleyumo.servlet

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import jakarta.servlet.http.HttpSession

/**
 * @author uncle_yumo
 * @fileName LoginServlet
 * @createDate 2024/10/16 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@WebServlet("/LoginServlet")
class LoginServlet : HttpServlet() {
    override fun doGet(request: HttpServletRequest?, response: HttpServletResponse?) {
        request?.characterEncoding = "UTF-8"
        response?.apply {
            characterEncoding = "UTF-8"
            setHeader("Content-Type", "text/plain;charset=UTF-8")
        }
        val username: String? = request?.getParameter("username")
        val password: String? = request?.getParameter("password")

        if (username != null && password != null) {
            if (username == password) {
                val session: HttpSession? = request.session
                session?.setAttribute("username", username)
                val userInfoCookie = Cookie("userInfo", "$username|$password")
                userInfoCookie.maxAge = 60 * 5
                response?.apply {
                    addCookie(userInfoCookie)
                    sendRedirect("welcome.jsp")
                }
            } else {
                response?.apply {
                    writer.append("用户名密码错误，请重新登录，5秒后自动跳转到登录页面")
                    setHeader("Refresh", "5;url=login.jsp")
                }
            }
        } else {
            response?.apply {
                writer.append("禁止直接访问，请重新登录，5秒后自动跳转到登录页面")
                setHeader("Refresh", "5;url=login.jsp")
            }
        }
    }

    override fun doPost(request: HttpServletRequest?, response: HttpServletResponse?) {
        doGet(request, response)
    }
}