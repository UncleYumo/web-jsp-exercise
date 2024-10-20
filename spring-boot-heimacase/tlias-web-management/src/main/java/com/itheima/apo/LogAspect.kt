package com.itheima.apo

import com.alibaba.fastjson.JSONObject
import com.itheima.mapper.OperateLogMapper
import com.itheima.pojo.OperateLog
import com.itheima.pojo.OperateLogKT
import com.itheima.uitils.JwtUtils
import com.itheima.utils.Color_Print_Utils
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import javax.servlet.http.HttpServletRequest

/**
 * @author uncle_yumo
 * @fileName LogAspect
 * @createDate 2024/10/20 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Component
@Aspect
class LogAspect {

    @Autowired
    private lateinit var operateLogMapper: OperateLogMapper

    @Autowired
    private lateinit var request: HttpServletRequest  // 注入HttpServletRequest对象

    @Around("@annotation(com.itheima.anno.Log)")
    fun recordLog(joinPoint : ProceedingJoinPoint) : Any {

        // 开始时间
        val startTime = System.currentTimeMillis()
        // 调用原始目标的方法
        val proceed = joinPoint.proceed()
        // 结束时间
        val endTime = System.currentTimeMillis()
        // 耗时
        val methodCostTime = endTime - startTime

        // 获取请求头中的JWT令牌
        val jwtToken = request.getHeader("token")?: ""
        val claims = JwtUtils.parseJwtToken(jwtToken)
        val operateUserId = claims["id"] as Int

        val operateLogKt = OperateLogKT(
            id = null,
            operateUser = operateUserId,
            operateTime = LocalDateTime.now(),
            className = joinPoint.target.javaClass.name,
            methodName = joinPoint.signature.name,
            methodParams = joinPoint.args.joinToString(),
            returnValue = JSONObject.toJSONString(proceed),
            costTime = methodCostTime
        )

        // 记录操作日志
        operateLogMapper.insert(operateLogKt)

        Color_Print_Utils.getInstance().printlnCyanBlack("操作日志记录 | ${operateLogKt.toString()}")
        return proceed
    }
}