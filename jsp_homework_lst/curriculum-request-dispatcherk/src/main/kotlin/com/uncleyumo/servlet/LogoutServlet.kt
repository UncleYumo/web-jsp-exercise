package com.uncleyumo.servlet

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import jakarta.servlet.http.HttpSession

/**
 * @author uncle_yumo
 * @fileName LogoutServlet
 * @createDate 2024/10/16 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@WebServlet("/LogoutServlet")
class LogoutServlet : HttpServlet() {
    override fun doGet(request: HttpServletRequest?, response: HttpServletResponse?) {
        response?.apply {
            characterEncoding = "UTF-8"
            setHeader("Content-Type", "text/plain;charset=UTF-8")
        }
        val session = request?.getSession(false)
        if (session!= null) {
            session.invalidate()  // 销毁session
            val usernameInfo = Cookie("userInfo","")
            usernameInfo.maxAge = 0  // 设置cookie失效
            response?.apply {
                addCookie(usernameInfo)  // 销毁cookie
                writer.append("注销成功，5秒后跳转到登录页面")
                setHeader("Refresh", "5;url=login.jsp")
            }
        } else {
            response?.apply {
                writer.append("您尚未登录，无需注销, 5秒后跳转到登录页面")
                setHeader("Refresh", "5;url=login.jsp")
            }
        }
    }

    override fun doPost(request: HttpServletRequest?, response: HttpServletResponse?) {
        doGet(request, response)
    }
}