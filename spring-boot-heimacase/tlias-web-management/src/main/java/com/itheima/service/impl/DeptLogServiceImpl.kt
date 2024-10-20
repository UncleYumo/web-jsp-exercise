package com.itheima.service.impl

import com.itheima.mapper.DeptLogMapper
import com.itheima.pojo.DeptLog
import com.itheima.service.DeptLogService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

/**
 * @author uncle_yumo
 * @fileName DeptLogServiceImpl
 * @createDate 2024/10/19 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Service  // 声明当前类是一个Spring Bean
open class DeptLogServiceImpl : DeptLogService {

    @Autowired  // 自动注入DeptLogMapper
    private lateinit var deptLogMapper: DeptLogMapper

    @Transactional(propagation = Propagation.REQUIRES_NEW)  // 声明当前方法是一个事务方法
    override fun insert(deptLog: DeptLog) {
        deptLogMapper.insert(deptLog)
    }
}