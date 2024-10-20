package com.itheima.apo

import com.itheima.utils.Color_Print_Utils
import lombok.extern.slf4j.Slf4j
import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.*
import org.springframework.stereotype.Component
import java.time.LocalDateTime

/**
 * @author uncle_yumo
 * @fileName MyAspect
 * @createDate 2024/10/20 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Component
//@Aspect
class MyAspect {

    // 定义切点
//    @Pointcut("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    @Pointcut("@annotation(com.itheima.apo.MyLog)")
    fun pt() {
    }
}


//    @Before("pt()")
//    fun before() {
//        Color_Print_Utils.getInstance().printlnYellow("【Aspect 动态代理】 | before()")
//    }
//
//    @Around("pt()")
//    fun around(proceedingJoinPoint: ProceedingJoinPoint) : Any {
//        Color_Print_Utils.getInstance().printlnYellow("【Aspect 动态代理】 | around-before")
//        val startTime = System.currentTimeMillis()
//
//        // 调用目标对象的原始方法执行
//        val proceed = proceedingJoinPoint.proceed()
////
////        val endTime = System.currentTimeMillis()
//
//        Color_Print_Utils.getInstance().printlnYellow("【Aspect 动态代理】 | around-after")
////        Color_Print_Utils.getInstance().printlnCyanBlack(
////            "!!!!!!! 执行方法：${proceedingJoinPoint.signature.name}，耗时：${endTime - startTime}ms"
////        )
//        return proceed
//    }
//
//    @After("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
//    fun after() {
//        Color_Print_Utils.getInstance().printlnYellow("【Aspect 动态代理】 | after()")
//    }
//
//    @AfterReturning("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
//    fun afterReturning() {
//        Color_Print_Utils.getInstance().printlnYellow("【Aspect 动态代理】 | afterReturning()")
//    }
//
//    @AfterThrowing("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
//    fun afterThrowing() {
//        Color_Print_Utils.getInstance().printlnYellow("【Aspect 动态代理】 | afterThrowing()")
//    }
//}