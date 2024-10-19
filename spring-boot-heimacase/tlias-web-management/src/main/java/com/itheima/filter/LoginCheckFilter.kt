package com.itheima.filter

import com.alibaba.fastjson.JSONObject
import com.itheima.pojo.Result_KT
import com.itheima.uitils.JwtUtils
import org.slf4j.LoggerFactory
import org.springframework.util.StringUtils
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.annotation.WebFilter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author uncle_yumo
 * @fileName LoginCheckFilter
 * @createDate 2024/10/19 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

//@WebFilter(urlPatterns = ["/*"])
class LoginCheckFilter : Filter {
    private val logger = LoggerFactory.getLogger("【Login-Check-Filter】")
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {

        val req = request as HttpServletRequest
        val resp = response as HttpServletResponse

        // 获取请求URL

        val url = req.requestURL.run {
            logger.info("请求URL：${this}")
            toString()
        }

        // 判断请求URL中是否包含Login，如果包含则放行 | localhost:8080/login
        if (url.contains("login")) {
            logger.info("请求URL包含login | 放行")
            chain?.doFilter(request, response)
            return
        }

        // 获取请求头中的token
        val jwtToken: String? = req.getHeader("token")
        // 判断令牌是否存在，如果不存在则跳转到登录页面
        if (!StringUtils.hasLength(jwtToken?: "")) {
            logger.info("请求头Token为空 | 跳转到登录页面")
            Result_KT.error("NOT_LOGIN")
            // 手动将对象转换为json字符串，并设置到response中 | fastjson
            val notLoginJsonStr = JSONObject.toJSONString(Result_KT.error("NOT_LOGIN"))
            resp.writer.write(notLoginJsonStr)
            return
        }

        // 解析令牌，如果解析失败则跳转到登录页面
        try {
            JwtUtils.parseJwtToken(jwtToken?: "")
        } catch (e: Exception) {
            logger.error("解析令牌失败 | 跳转到登录页面")
            Result_KT.error("NOT_LOGIN")
            // 手动将对象转换为json字符串，并设置到response中 | fastjson
            val notLoginJsonStr = JSONObject.toJSONString(Result_KT.error("NOT_LOGIN"))
            resp.writer.write(notLoginJsonStr)
            return
        }

        // 如果令牌存在且有效，则放行
        logger.info("请求头Token存在且有效 | 放行")
        chain?.doFilter(request, response)
    }
}