package com.itheima.apo

import com.itheima.utils.Color_Print_Utils
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

/**
 * @author uncle_yumo
 * @fileName TimeAspect
 * @createDate 2024/10/20 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Component
@Aspect
class TimeAspect {
    @Around("com.itheima.apo.MyAspect.pt()")
    fun recordTime(joinPoint: ProceedingJoinPoint) : Any {
        Color_Print_Utils.getInstance().printlnCyanBlack("AOP from ${this.javaClass.simpleName}")
        val start = System.currentTimeMillis()
        val proceed = joinPoint.proceed()
        val end = System.currentTimeMillis()
        Color_Print_Utils.getInstance().printlnCyanBlack(
            "Method : ${joinPoint.signature.name} | Execution time: ${end - start} ms"
        )
        return proceed
    }

}