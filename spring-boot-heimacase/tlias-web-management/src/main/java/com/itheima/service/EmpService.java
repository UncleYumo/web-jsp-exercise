package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean_KT;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */

public interface EmpService {

    // 分页查询员工
    PageBean_KT page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    // 实现批量删除员工
    void delete(List<Integer> ids);

    // 添加员工信息
    void add(Emp emp);
}
