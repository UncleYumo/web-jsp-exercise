package com.itheima.apo

import java.lang.annotation.ElementType
import java.lang.annotation.RetentionPolicy

/**
 * @author uncle_yumo
 * @fileName MyLog
 * @createDate 2024/10/20 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

/*
Java的注解方式
 */
//@Retention(RetentionPolicy.RUNTIME)  // 注解的生命周期，在运行时可以获取到
//@Target(ElementType.METHOD)

/*
Kotlin的注解方式
 */
@Retention(AnnotationRetention.RUNTIME)  // 注解的生命周期，在运行时可以获取到
@Target(AnnotationTarget.FUNCTION)  // 注解的作用目标，这里是方法级别的注解
annotation class MyLog()
