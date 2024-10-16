package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean_KT;
import com.itheima.service.EmpService;
import com.itheima.utils.Color_Print_Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service  // 注解说明：将DeptServiceImpl类声明为Spring的Bean对象，使其可以被Spring IoC容器管理
public class EmpServiceImpl implements EmpService {

    @Autowired  // 注解说明：自动装配，将DeptMapper对象注入到DeptServiceImpl对象中
    private EmpMapper empMapper;

    @Override
    public PageBean_KT page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {

        PageHelper.startPage(page, pageSize);
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;

        // 封装PageBean_KT对象并返回
        return new PageBean_KT(p.getTotal(), p.getResult());

        //        // 获取总记录数
//        Long count = empMapper.count();
////        Color_Print_Utils.getInstance().printlnYellow("总记录数：" + count);
//        // 获取分页数据
//        Integer indexInitial = (page - 1) * pageSize;
//        List<Emp> empList = empMapper.page(indexInitial, pageSize);

    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void add(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        emp.setCreateTime(LocalDateTime.now());
        System.out.println("emp:" + emp.toString());
        empMapper.add(emp);
    }
}
