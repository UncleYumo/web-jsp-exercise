package com.itheima.controller

import com.itheima.pojo.Emp
import com.itheima.pojo.Result_KT
import com.itheima.service.EmpService
import com.itheima.uitils.JwtUtils
import io.jsonwebtoken.Jwt
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * @author uncle_yumo
 * @fileName LoginController
 * @createDate 2024/10/17 October
 * @school 无锡学院
 * @studentID 22344131
 * @description To dispose All Session of Login
 */

@Slf4j
@RestController
class LoginController {
    private val logger = LoggerFactory.getLogger(LoginController::class.java.name)

    @Autowired
    private lateinit var empService: EmpService

    @PostMapping("/login")
    fun login(@RequestBody emp: Emp): Result_KT {
        logger.info("处理登录请求 | 请求方式: POST | 请求参数: emp=$emp")
        val e: Emp = empService.login(emp) ?: return Result_KT.error("用户名或密码错误")

        // 登录成功，生成JWT令牌并下发
        val claimsMap = HashMap<String, Any>().apply {
            put("id", e.id)
            put("name", e.name)
            put("username", e.username)
        }
        val jwtToken: String = JwtUtils.generateJwtToken(claimsMap)  // 包含了当前员工的身份信息
        return Result_KT.success(jwtToken)
    }
}