package com.itheima.pojo

import java.time.LocalDateTime

/**
 * @author uncle_yumo
 * @fileName OperateLogKT
 * @createDate 2024/10/20 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

data class OperateLogKT(
    var id: Int?,
    var operateUser: Int,
    var operateTime: LocalDateTime,
    var className: String,
    var methodName: String,
    var methodParams: String,
    var returnValue: String,
    var costTime: Long
)
