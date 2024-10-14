package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {
    // 查询所有部门
    List<Dept> list();

    // 根据id查询部门
    void delete(Integer id);

    // 新增部门
    void add(Dept dept);

    // 根据id查询部门
    Dept getDeptById(Integer id);

    // 修改部门
    void updateDept(Dept dept);
}
