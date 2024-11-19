package com.example.jspjdbcexerc05.jdbc

import com.example.jspjdbcexerc05.pojo.goods
import com.example.jspjdbcexerc05.utils.ParseYaml
import com.mysql.cj.jdbc.Driver
import com.uncleyumo.utils.Color_Print_Utils
import java.sql.Connection
import java.sql.DriverManager
import java.sql.Statement

/**
 * @author uncle_yumo
 * @fileName MysqlConnectionUtil
 * @createDate 2024/11/20 November
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

class MysqlConnectionUtil() {

    private var connection: Connection

    init {
        connection = loadConnection()
    }

    private fun loadConnection(): Connection {
        val ymlData = ParseYaml().getYamlData()
        val url: String = ((ymlData["uncleyumo"] as Map<*, *>)["jdbc"] as Map<*, *>)["url"] as String
        val username: String = ((ymlData["uncleyumo"] as Map<*, *>)["jdbc"] as Map<*, *>)["username"] as String
        val password: String = ((ymlData["uncleyumo"] as Map<*, *>)["jdbc"] as Map<*, *>)["password"] as String
        val driverClassName: String =
            ((ymlData["uncleyumo"] as Map<*, *>)["jdbc"] as Map<*, *>)["driver-class-name"] as String
        Class.forName(driverClassName)  // load driver
        return DriverManager.getConnection(url, username, password)
    }

    fun getConnection() = connection

    fun closeConnection() {
        connection.close()
    }
}

fun main() {
    Color_Print_Utils.getInstance().programStart()

    val conn = MysqlConnectionUtil().getConnection()
    val stmt: Statement = conn.createStatement()
    val sql = "SELECT * FROM goods"
    val rs = stmt.executeQuery(sql)

    val goodList: ArrayList<goods> = ArrayList()

    while (rs.next()) {
        goodList.add(goods().apply {
            gid = rs.getInt("gid")
            gName = rs.getString("gName")
            gPrice = rs.getDouble("gPrice")
        })
    }

    goodList.stream().forEach { Color_Print_Utils.getInstance().printlnYellow(it.toString()) }

    Color_Print_Utils.getInstance().programEnd()
}