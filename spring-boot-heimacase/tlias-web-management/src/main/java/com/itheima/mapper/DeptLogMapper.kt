package com.itheima.mapper

import com.itheima.pojo.DeptLog
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper

/**
 * @author uncle_yumo
 * @fileName DeptLogMapper
 * @createDate 2024/10/19 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Mapper
interface DeptLogMapper {
    @Insert("Insert Into dept_log (create_time, description) values (#{createTime}, #{description})")
    fun insert(deptLog: DeptLog)
}
