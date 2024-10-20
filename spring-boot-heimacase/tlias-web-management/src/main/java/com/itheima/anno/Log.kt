package com.itheima.anno

/**
 * @author uncle_yumo
 * @fileName Log
 * @createDate 2024/10/20 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Retention(AnnotationRetention.RUNTIME)  // 注解的生命周期，在运行时期
@Target(AnnotationTarget.FUNCTION)  // 注解的作用目标，在函数上
annotation class Log()
