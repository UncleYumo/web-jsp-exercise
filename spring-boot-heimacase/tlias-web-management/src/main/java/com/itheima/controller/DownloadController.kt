package com.itheima.controller

import com.itheima.pojo.Result_KT
import com.itheima.uitils.AliOSSUtils
import com.itheima.uitils.AliOSSUtils_JAVA
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ServerWebExchange
import java.io.BufferedInputStream
import java.io.File
import java.io.InputStream
import java.io.OutputStream
import java.nio.file.Files
import java.nio.file.Paths
import javax.servlet.http.HttpServletResponse

/**
 * @author uncle_yumo
 * @fileName DownloadMapper
 * @createDate 2024/10/15 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */
@RestController  // 控制器注解
@RequestMapping("/warehouse")  // 请求映射
class DownloadController {

    @Autowired
    val aliOSSUtils: AliOSSUtils? = null

    @GetMapping("/download/{fileName}")
    fun download(response: HttpServletResponse, @PathVariable fileName: String) {
        val projectPath = Paths.get(System.getProperty("user.dir")).toAbsolutePath()
        println("projectPath: $projectPath")
        val filePath = "$projectPath/tlias-web-management/src/main/resources/tempfile/warehouse/$fileName"
        println("filePath: $filePath")
        val file: File = File(filePath)  // 读取文件
        if (!file.exists()) {
            response.status = HttpStatus.NOT_FOUND.value()  // 设置404状态码
            response.writer.write("文件不存在 | $filePath") // 在响应体中返回错误信息
            return  // 退出方法
        }

        try {
            response.reset()  // 清空缓冲区
            response.contentType = "application/octet-stream"  // 设置响应类型
            response.characterEncoding = "utf-8"  // 设置编码格式
            response.setContentLength(file.length().toInt())  // 设置响应长度
            response.setHeader("Content-Disposition", "attachment;filename=(FromServer)$fileName")

            // 读取文件流
            BufferedInputStream(Files.newInputStream(file.toPath())).use { bis ->
                response.outputStream.use { os ->  // 获取输出流
                    val buff = ByteArray(1024)  // 设置缓冲区大小
                    var len: Int
                    while (bis.read(buff).also { len = it } != -1) {
                        os.write(buff, 0, len)
                    }
                    os.flush()  // 刷新输出流
                }
                response.status = HttpStatus.OK.value()  // 设置200状态码
            }
        } catch (e: Exception) {
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value()  // 设置500状态码
            response.writer.write("服务器错误 | ${e.message}") // 返回错误信息
        }
    }

    @GetMapping("/test")
    fun testGetKey() : Result_KT {
        val key: String? = aliOSSUtils?.getBucketName()
        return Result_KT.success("Key | ${key?: "key is null"}")
    }

}