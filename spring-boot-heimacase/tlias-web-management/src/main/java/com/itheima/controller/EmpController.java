package com.itheima.controller;

import com.itheima.pojo.PageBean_KT;
import com.itheima.pojo.Result_KT;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 员工管理Controller
 */

@RestController
@RequestMapping("/emps")
public class EmpController {

    // 注入员工管理Service
    @Autowired
    private EmpService empService;

    @GetMapping()
    public Result_KT page(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        PageBean_KT pageBean = empService.page(page, pageSize);
        return Result_KT.Companion.success(pageBean);
    }
}
