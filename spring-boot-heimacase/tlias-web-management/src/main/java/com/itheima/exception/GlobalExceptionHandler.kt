package com.itheima.exception

import com.itheima.pojo.Result_KT
import com.itheima.utils.Color_Print_Utils
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * @author uncle_yumo
 * @fileName ClobalExceptionHandler
 * @createDate 2024/10/19 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@RestControllerAdvice
class GlobalExceptionHandler {
    // 全局异常处理
    @ExceptionHandler(Exception::class)
    fun ex(e: Exception) : Result_KT {
        Color_Print_Utils.getInstance().printlnRed("全局异常处理 |  ${e.message}")
        return Result_KT.error("全局异常处理 | 服务器错误 !!!! 请联系管理员 !!!!")
    }
}