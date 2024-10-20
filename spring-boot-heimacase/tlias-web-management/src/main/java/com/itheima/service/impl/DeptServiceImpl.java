package com.itheima.service.impl;

import com.itheima.apo.MyLog;
import com.itheima.mapper.DeptMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Dept;
import com.itheima.pojo.DeptLog;
import com.itheima.service.DeptLogService;
import com.itheima.service.DeptService;
import com.itheima.utils.Color_Print_Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service  // 注解说明：将DeptServiceImpl类声明为Spring的Bean对象，使其可以被Spring IoC容器管理
public class DeptServiceImpl implements DeptService {

    //注入Mapper接口
    @Autowired  // 注解说明：将DeptMapper注入到DeptServiceImpl类中
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptLogService deptLogService;

    @MyLog
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Transactional(rollbackFor = Exception.class)  // 注解说明：声明当前方法为事务方法，如果该方法抛出异常，则事务回滚
    @Override
    public void delete(Integer id) throws Exception {
        try {
            // 根据ID删除部门数据
            deptMapper.delete(id);
            // 根据部门ID删除部门下属的员工数据
            empMapper.deleteByDeptId(id);
            throw new RuntimeException("删除部门与对应员工数据失败");
        } catch (Exception e) {
            Color_Print_Utils.getInstance().printlnYellow("删除部门失败，原因：" + e.getMessage());
        } finally {
            // 事务提交
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作，此次解散的是" + id + "号部门");
            deptLogService.insert(deptLog);
        }
    }

    @MyLog
    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }

    @Override
    public Dept getDeptById(Integer id) {
//        int i = 1 / 0;  // 用于触发异常，测试AOP
        return deptMapper.getDeptById(id);
    }

    @Override
    public void updateDept(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateDept(dept);
    }
}
