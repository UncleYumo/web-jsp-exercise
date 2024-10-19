package com.itheima.filter

import com.itheima.utils.Color_Print_Utils
import org.slf4j.LoggerFactory
import javax.servlet.*
import javax.servlet.annotation.WebFilter

/**
 * @author uncle_yumo
 * @fileName DemoFilter
 * @createDate 2024/10/19 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

//@WebFilter(urlPatterns = ["/*"])
class DemoFilter: Filter {
    private val logger = LoggerFactory.getLogger("【Filter | DemoFilter】")

    // Method for initializing the filter, called by the container。 Only called once per filter instance.
    override fun init(filterConfig: FilterConfig?) {
//        super.init(filterConfig)
        logger.info("Filter initialized | init()")
    }

    // Method for processing the request and response, called by the container.
    // The chain parameter is used to pass the request to the next filter in the chain,
    // or to the servlet if there are no more filters.
    override fun doFilter(p0: ServletRequest?, p1: ServletResponse?, p2: FilterChain?) {
        Color_Print_Utils.getInstance().printlnYellow("Demo Filter had intercepted request | doFilter()")
        // 放行
        Color_Print_Utils.getInstance().printlnCyan("Demo Pre-Release Logic below | doFilter()")
        p2?.doFilter(p0, p1)
        Color_Print_Utils.getInstance().printlnGreen("Demo Post-Release Logic below | doFilter()")
    }

    // Method for destroying the filter, called by the container.
    override fun destroy() {
        Color_Print_Utils.getInstance().printlnYellow("Demo Filter had destroyed | destroy()")
    }
}