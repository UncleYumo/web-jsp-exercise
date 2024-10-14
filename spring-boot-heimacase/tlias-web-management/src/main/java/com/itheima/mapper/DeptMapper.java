package com.itheima.mapper;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result_KT;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * 部门管理
 */
@Mapper  // 注解功能：将当前类注册为mybatis的mapper接口，使mybatis可以扫描到该接口并完成相应的映射
public interface DeptMapper {

    // 查询所有部门
    @Select("select * from dept")
    List<Dept> list();

    // 根据ID删除部门
    @Delete("delete from dept where id = #{id}")
    void delete(Integer id);

    // 添加部门
    @Insert("insert into dept(name, create_time, update_time) values " +
            "(#{name}, #{createTime}, #{updateTime})")
    void add(Dept dept);

    // 根据ID查询部门
    @Select("select * from dept where id = #{id}")
    Dept getDeptById(Integer id);

    // 更新部门信息
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void updateDept(Dept dept);
}
