package com.example.jspjdbcexerc05.utils

import org.yaml.snakeyaml.Yaml

/**
 * @author uncle_yumo
 * @fileName ParseYaml
 * @createDate 2024/11/20 November
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

class ParseYaml {
    fun getYamlData(filePath: String = "application.yml"): Map<String, Any> {
        val yaml: Yaml = Yaml()
        return yaml.load(ParseYaml::class.java.classLoader.getResourceAsStream(filePath))
    }
}

fun main() {
    val ymlData = ParseYaml().getYamlData()
    val url: String = ((ymlData["uncleyumo"] as Map<*, *>)["jdbc"] as Map<*, *>)["url"] as String
    val username: String = ((ymlData["uncleyumo"] as Map<*, *>)["jdbc"] as Map<*, *>)["username"] as String
    val password: String = ((ymlData["uncleyumo"] as Map<*, *>)["jdbc"] as Map<*, *>)["password"] as String
    val driverClassName: String = ((ymlData["uncleyumo"] as Map<*, *>)["jdbc"] as Map<*, *>)["driver-class-name"] as String

    println("url: $url")
    println("username: $username")
    println("password: $password")
    println("driverClassName: $driverClassName")
}