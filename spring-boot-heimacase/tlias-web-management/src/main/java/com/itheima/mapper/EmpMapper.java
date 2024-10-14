package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 员工管理
 */

@Mapper
public interface EmpMapper {

    // 查询员工总记录数
    @Select("select count(*) from emp")
    public Long count();

    // 分页查询员工列表
    @Select("select * from emp limit #{start},#{pageSize}")
    public List<Emp> page(Integer start, Integer pageSize);
}
