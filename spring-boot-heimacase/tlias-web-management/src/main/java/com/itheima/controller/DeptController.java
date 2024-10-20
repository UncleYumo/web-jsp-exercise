package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result_KT;
import com.itheima.service.DeptService;
import com.itheima.service.impl.DeptServiceImpl;
import com.itheima.utils.Color_Print_Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * 部门管理Controller
 */

@Slf4j  // 注解功能：将类声明为一个日志类，并自动生成日志实例
@RestController  // 注解功能：将类声明为一个控制器，使其可以处理HTTP请求
@RequestMapping("/depts")  // 注解功能：设置请求路径前缀
public class DeptController {

    // 注入Service层对象
    @Autowired  // 注解功能：自动装配DeptService
    private DeptService deptService;

    // GET(查询) - 查询全部部门数据
    // @RequestMapping(value = "/depts" ,method = RequestMethod.GET)
    @GetMapping()
    public Result_KT list() {
        log.info("查询全部部门数据 | 请求方式：GET");
        List<Dept> deptList = deptService.list();
        return Result_KT.Companion.success(deptList);
    }


    // DELETE(删除) - 删除指定部门数据
    @Log
    @DeleteMapping("/{id}")
    public Result_KT delete(@PathVariable("id") Integer id) throws Exception {
        log.info("删除指定部门数据 | 请求方式：DELETE | 请求参数：id={}", id);
        deptService.delete(id);
        return Result_KT.Companion.success();
    }


    // 新增部门
    @Log
    @PostMapping()
    public Result_KT add(@RequestBody Dept dept) {

        log.info("新增部门 | 请求方式：POST | 请求参数：{}", dept);
        deptService.add(dept);
        return Result_KT.Companion.success(dept);
    }


    // 根据ID查询部门
    @GetMapping("/{id}")
    public Result_KT getDeptById(@PathVariable("id") Integer id) {
        log.info("根据ID查询部门 | 请求方式：GET | 请求参数：id={}", id);
        Dept dept = deptService.getDeptById(id);
        return Result_KT.Companion.success(dept);
    }

    // 根据ID和部门名称修改部门
    @Log
    @PutMapping()
    public Result_KT updateDept(@RequestBody Dept dept) {
        log.info("根据ID和部门名称修改部门 | 请求方式：PUT");
        deptService.updateDept(dept);
        return Result_KT.Companion.success();
    }

}
