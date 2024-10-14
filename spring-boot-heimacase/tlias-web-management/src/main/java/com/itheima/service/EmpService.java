package com.itheima.service;

import com.itheima.pojo.PageBean_KT;

/**
 * 员工管理
 */

public interface EmpService {

    // 分页查询员工
    PageBean_KT page(Integer page, Integer pageSize);
}
