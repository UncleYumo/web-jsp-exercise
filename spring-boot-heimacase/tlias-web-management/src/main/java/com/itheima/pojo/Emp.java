package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 员工实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    public Integer id; //ID
    public String username; //用户名
    public String password; //密码
    public String name; //姓名
    public Short gender; //性别 , 1 男, 2 女
    public String image; //图像url
    public Short job; //职位 , 1 班主任 , 2 讲师 , 3 学工主管 , 4 教研主管 , 5 咨询师
    public LocalDate entrydate; //入职日期
    public Integer deptId; //部门ID
    public LocalDateTime createTime; //创建时间
    public LocalDateTime updateTime; //修改时间
}
