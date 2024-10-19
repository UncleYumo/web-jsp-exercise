package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */

@Mapper
public interface EmpMapper {

//    // 查询员工总记录数
//    @Select("select count(*) from emp")
//    public Long count();
//
//    // 分页查询员工列表
//    @Select("select * from emp limit #{start},#{pageSize}")
//    public List<Emp> page(Integer start, Integer pageSize);

    // 员工信息查询 PageHelper分页插件
    // @Select("select * from emp")
//    @Select("")
    // 已设置XML映射
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    // 批量删除员工
    void delete(List<Integer> ids);

    @Insert("insert into emp" +
            " (username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            " values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    void add(Emp emp);

    // Select Employee according to Emo's id
    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    void update(Emp emp);

    // Select Employee according to username and password
    @Select("Select * from emp where username = #{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);

    // Delete Employee according to dept_id
    @Delete("delete from emp where dept_id = #{deptId}")
    void deleteByDeptId(Integer deptId);
}
