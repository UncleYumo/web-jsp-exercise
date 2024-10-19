package com.itheima.config

import com.itheima.interceptor.LoginCheckInterceptor
import com.itheima.utils.Color_Print_Utils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * @author uncle_yumo
 * @fileName WebConfig
 * @createDate 2024/10/19 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Configuration
open class WebConfig : WebMvcConfigurer {
    @Autowired
    val loginCheckInterceptor: LoginCheckInterceptor? = null

    override fun addInterceptors(registry: InterceptorRegistry) {
        if (loginCheckInterceptor == null) {
            Color_Print_Utils.getInstance().printlnYellow("loginCheckInterceptor is null")
            return
        }
        registry.run {
            addInterceptor(loginCheckInterceptor)
        }.addPathPatterns("/**")
//            .excludePathPatterns("/login")
    }
}