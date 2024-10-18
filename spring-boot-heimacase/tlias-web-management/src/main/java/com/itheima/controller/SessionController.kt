package com.itheima.controller

import com.itheima.pojo.Result_KT
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.boot.web.server.Cookie
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession

/**
 * @author uncle_yumo
 * @fileName SessionController
 * @createDate 2024/10/17 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Slf4j  // 日志注解：声明这是一个日志类，用于记录日志
@RestController  // 控制器注解：声明这是一个控制器类，用于处理HTTP请求
class SessionController {

    private val logger = LoggerFactory.getLogger(SessionController::class.java)

    @GetMapping("/c1")
    fun testSetCookie(response: HttpServletResponse): Result_KT {
        logger.info("testSetCookie() | 设置cookie")
        response.apply {
            addCookie(javax.servlet.http.Cookie("login_username", "admin"))
            addCookie(javax.servlet.http.Cookie("login_password", "123456"))
        }
        return Result_KT.success()
    }

    @GetMapping("/c2")
    fun testGetCookie(request: HttpServletRequest): Result_KT {
        logger.info("testGetCookie() | 获取cookie")
        val cookies = request.cookies ?: emptyArray()
        for (cookie in cookies) {
            println("Current Cookie: ${cookie.name} = ${cookie.value}")
            if (cookie.name == "login_username") println("!!!Get Customized Cookie: ${cookie.value}")
        }
        return Result_KT.success()
    }

    @GetMapping("/s1")
    fun testSession01(session: HttpSession): Result_KT {
        logger.info("testSession01() | Session-HashCode -> ${session.hashCode()}")
        session.setAttribute("loginUser-session", "Tom")  // 保存session属性
        return Result_KT.success()
    }

    @GetMapping("/s2")
    fun testSession02(request: HttpServletRequest): Result_KT {
        val session = request.session
        logger.info("testSession02() | Session-HashCode -> ${session.hashCode()}")
        val loginUser = session.getAttribute("loginUser-session")  // 获取session属性
        logger.info("testSession02() | loginUser -> $loginUser")
        return Result_KT.success()

    }

}
