package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author uncle_yumo
 * @fileName OperateLog
 * @createDate 2024/10/20 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperateLog {
    public Integer id; // id 主键
    public Integer operateUser;  // operate_user 操作用户的id
    public LocalDateTime operateTime; // operate_time 操作时间
    public String className; // class_name 操作方法所在类名
    public String methodName; // method_name 操作方法名
    public String methodParams; // method_params 操作方法参数
    public String returnValue; // return_value 操作方法返回值
    public Long costTime; // cost_time 操作耗时
}
