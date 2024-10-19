package com.itheima.uitils

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.util.Date

/**
 * @author uncle_yumo
 * @fileName JwtUtils
 * @createDate 2024/10/18 October
 * @school 无锡学院
 * @studentID 22344131
 * @description JWT工具类，用于生成和解析JWT
 */

class JwtUtils {
    companion object {
        private const val SIGN_KEY: String = "itheima" //签名密钥
        private const val EXPIRE_TIME: Long = 1000 * 3600 * 12  // 12小时过期

        /*
         * 生成JWT token
         */
        fun generateJwtToken(claims: Map<String, Any>): String {
            val jwtToken = Jwts.builder().run {
                addClaims(claims)
                signWith(SignatureAlgorithm.HS256, SIGN_KEY)
                setExpiration(Date(System.currentTimeMillis() + EXPIRE_TIME))
                compact()
            }
            return jwtToken
        }

        /*
         * 解析JWT token
         */
        fun parseJwtToken(jwtToken: String): Claims {
            val claims: Claims = Jwts.parser().run {
                setSigningKey(SIGN_KEY)
                parseClaimsJws(jwtToken).body
            }
            return claims
        }
    }
}