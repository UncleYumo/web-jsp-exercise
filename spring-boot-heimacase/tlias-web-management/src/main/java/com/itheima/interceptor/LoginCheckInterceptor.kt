package com.itheima.interceptor

import com.alibaba.fastjson.JSONObject
import com.itheima.pojo.Result_KT
import com.itheima.uitils.JwtUtils
import com.itheima.utils.Color_Print_Utils
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author uncle_yumo
 * @fileName LoginCheckInterc
 * @createDate 2024/10/19 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Component
class LoginCheckInterceptor : HandlerInterceptor {
    // 目标资源方法运行前调用 | return true 放行，return false 拦截
    override fun preHandle(request: HttpServletRequest,response: HttpServletResponse, handler: Any): Boolean {
        Color_Print_Utils.getInstance().printlnYellow("LoginCheckInterceptor preHandle() | 目标资源方法运行前调用")
        // 获取请求的url
        val url = request.requestURL.toString()

        // 判断请求的url中是否包含login，如果包含则说明是登录页面，放行
        if (url.contains("login")) {
            Color_Print_Utils.getInstance().printlnGreen("LoginCheckInterceptor preHandle() | 登录页面放行")
            return true  // 放行
        }

        // 到达此处说明登录页面，先提取请求中的token
        val token: String = request.getHeader("token")?: ""

        // 判断令牌是否为空，如果不存在则返回错误结果
        if (token.isEmpty()) {
            Color_Print_Utils.getInstance().printlnRed("LoginCheckInterceptor preHandle() | 令牌为空，返回错误结果")
            val error = Result_KT.error("NOT_LOGIN")
            val errorJson = JSONObject.toJSONString(error)
            response.writer.write(errorJson)
            // 结束请求
            return false
        }

        // 解析token，判断是否有效
        try {
            JwtUtils.parseJwtToken(token)
        } catch (e: Exception) {
            Color_Print_Utils.getInstance().printlnRed(e.message?: "Exception message is null")
            Color_Print_Utils.getInstance().printlnYellow("LoginCheckInterceptor preHandle() | 令牌解析失败，返回错误结果")
            val error = Result_KT.error("NOT_LOGIN")
            val errorJson = JSONObject.toJSONString(error)
            response.writer.write(errorJson)
            // 结束请求
            return false
        }

        // 到达此处说明令牌有效，放行
        Color_Print_Utils.getInstance().printlnGreen("LoginCheckInterceptor preHandle() | 令牌有效，放行")
        return true
    }

    // 目标资源方法运行后调用
    override fun postHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        modelAndView: ModelAndView?
    ) {
        Color_Print_Utils.getInstance().printlnYellow("LoginCheckInterceptor postHandle() | 目标资源方法运行后调用")
    }

    // 整个请求处理完毕后调用 | 视图渲染完成后调用
    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?
    ) {
        Color_Print_Utils.getInstance()
            .printlnYellow("LoginCheckInterceptor afterCompletion() | 整个请求处理完毕后调用")
    }
}