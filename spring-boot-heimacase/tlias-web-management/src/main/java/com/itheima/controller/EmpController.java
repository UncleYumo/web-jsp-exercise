package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean_KT;
import com.itheima.pojo.Result_KT;
import com.itheima.service.EmpService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理Controller
 */

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    // 注入员工管理Service
    @Autowired
    private EmpService empService;

    @GetMapping()
    public Result_KT page(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize,
            String name, Short gender,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end
    ) {
        PageBean_KT pageBean = empService.page(page, pageSize, name, gender, begin, end);
        log.info("分页查询 | 参数 | {} | {} | {} | {} | {} | {}", page, pageSize, name, gender, begin, end);
        return Result_KT.Companion.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result_KT delete(@PathVariable List<Integer> ids) {
        log.info("删除员工 | 参数 | {}", ids);
        empService.delete(ids);
        return Result_KT.Companion.success();
    }

    @PostMapping()
    public Result_KT add(@RequestBody Emp emp) {
        log.info("新增员工 | 参数 | {}", emp);
        empService.add(emp);
        return Result_KT.Companion.success(emp);
    }

    @PostMapping("/upload")
    public Result_KT upload(
            String name,
            String age,
            @RequestParam("image") MultipartFile file
    ) {
        log.info("上传信息与文件测试");

        final String fileName = file.getOriginalFilename();
        final String contentType = file.getContentType();

        System.out.println(
                "name | " + name +
                        "\nage | " + age +
                        "\nfileName | " + fileName +
                        "\ncontentType | " + contentType
        );

        return Result_KT.Companion.success("上传成功");
    }

    @GetMapping("/{id}")
    public Result_KT getById(@PathVariable Integer id) {
        log.info("查询员工 | 参数 | {}", id);
        Emp emp = empService.getById(id);
        return Result_KT.Companion.success(emp);
    }

    @PutMapping()
    public Result_KT update(@RequestBody Emp emp) {
        log.info("修改员工 | 参数 | {}", emp);
        try {
            empService.update(emp);
            return Result_KT.Companion.success();
        } catch (Exception e) {
            log.error("更新员工失败: {}", e.getMessage());
            return Result_KT.Companion.error("更新失败，员工不存在或其他错误");
        }
    }

}
