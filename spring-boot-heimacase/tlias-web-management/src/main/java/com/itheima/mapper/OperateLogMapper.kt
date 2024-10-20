package com.itheima.mapper

import com.itheima.pojo.OperateLog
import com.itheima.pojo.OperateLogKT
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper

/**
 * @author uncle_yumo
 * @fileName OperateLogMapper
 * @createDate 2024/10/20 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Mapper
interface OperateLogMapper {

    @Insert("insert into operate_log (operate_user, operate_time, class_name, method_name, method_params, return_value, cost_time) VALUES " +
            "(#{operateUser}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime})")
    fun insert(log: OperateLogKT)
}