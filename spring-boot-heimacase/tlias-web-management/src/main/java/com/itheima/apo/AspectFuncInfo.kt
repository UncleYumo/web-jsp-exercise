package com.itheima.apo

import com.itheima.utils.Color_Print_Utils
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

/**
 * @author uncle_yumo
 * @fileName AspectFuncInfo
 * @createDate 2024/10/20 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Component
//@Aspect
class AspectFuncInfo {

    @Around("com.itheima.apo.MyAspect.pt()")
    fun around(joinPoint: ProceedingJoinPoint) : Any {
        Color_Print_Utils.getInstance().printlnCyanBlack("${this.javaClass.name} | around() start")
        val result = joinPoint.proceed()

        // 获取目标对象的类名
        Color_Print_Utils.getInstance().printlnPurple("Target Class Name: ${joinPoint.target.javaClass.name}")
        // 获取目标方法的方法名
        Color_Print_Utils.getInstance().printlnPurple("Target Method Name: ${joinPoint.signature.name}")
        // 获取目标方法的参数
        Color_Print_Utils.getInstance().printlnPurple("Target Method Args[]: ${joinPoint.args}")
        // 获取目标方法的返回值
        Color_Print_Utils.getInstance().printlnPurple("Target Method Return Value: $result")

        Color_Print_Utils.getInstance().printlnCyanBlack("${this.javaClass.name} | around() end")
        return result
    }
}