package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author uncle_yumo
 * @fileName DeptLog
 * @createDate 2024/10/19 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */


@Data  // Lombok注解，自动生成get、set方法、构造方法、toString方法
@NoArgsConstructor  // Lombok注解，自动生成无参构造方法
@AllArgsConstructor  // Lombok注解，自动生成全参构造方法
public class DeptLog {
    private Integer id;
    private LocalDateTime createTime;
    private String description;
}
