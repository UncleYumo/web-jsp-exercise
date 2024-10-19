package com.itheima.filter

import com.itheima.utils.Color_Print_Utils
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.annotation.WebFilter

/**
 * @author uncle_yumo
 * @fileName AbcFilter
 * @createDate 2024/10/19 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

//@WebFilter(urlPatterns = ["/*"])
//class AbcFilter: Filter {
//    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
//        Color_Print_Utils.getInstance().printlnYellow("ABC Filter had intercepted request | doFilter()")
//
//        Color_Print_Utils.getInstance().printlnCyan("ABC Pre-Release Logic below | doFilter()")
//
//        Color_Print_Utils.getInstance().printlnGreen("ABC Post-Release Logic below | doFilter()")
//    }
//}