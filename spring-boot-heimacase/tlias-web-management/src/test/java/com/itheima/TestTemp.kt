package com.itheima

import com.itheima.uitils.AliOSSUtils_JAVA
import com.itheima.uitils.KeyRepository
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.collections.HashMap
import kotlin.io.path.Path

/**
 * @author uncle_yumo
 * @fileName TestTemp
 * @createDate 2024/10/15 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

class TestTemp {
    @Test  // 测试JWT的生成
    fun testJWT() {
        val claims = HashMap<String, Any>()
        claims.apply {
            put("id", 1)
            put("name", "tom")
            put("age", 25)
        }
        val jwtToken = Jwts.builder().apply {
            signWith(SignatureAlgorithm.HS256, "itheima")  // 设置加密算法和密钥
            setClaims(claims)
//            setExpiration(Date(System.currentTimeMillis() + 3600 * 1000))  // 设置过期时间为3600秒-即1小时
            setExpiration(Date(System.currentTimeMillis()))  // 设置过期时间为当前时间，即立即过期
        }.compact()
        println("JWT Token: $jwtToken")
    }

    @Test
    fun testJWTParse() {
        try {
            val jwtToken = "eyJhbGciOiJIUzI1NiJ9" +
                    ".eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTcyOTI1NzM4NywiYWdlIjoyNX0" +
                    ".xBJU-dlCrctEOKFivtm6IntO0_0nML9im3NkSuUaDLk"
//            val jwtToken: String = testJWT()
            val claims: Claims = Jwts.parser().run {
                setSigningKey("itheima")  // 设置密钥
                parseClaimsJws(jwtToken).body
            }
        } catch (e: ExpiredJwtException) {
            println("!!!!! -- ExpiredJwtException | ${e.message}")
            println("发生了Token过期异常，请重新登录获取新的Token")
        } catch (e: Exception) {
            println("!!!!! -- Exception | ${e.message}")
            println("!!!!! -- 发生了未知异常，请联系管理员")
        } finally {
            println("!!!!! -- JWT Token解析完成")
        }
    }
}
