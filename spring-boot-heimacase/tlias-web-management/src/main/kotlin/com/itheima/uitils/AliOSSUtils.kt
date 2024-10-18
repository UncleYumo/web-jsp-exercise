package com.itheima.uitils

import com.aliyun.oss.OSSClientBuilder
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.util.UUID

/**
 * @author uncle_yumo
 * @fileName AliOSSUtils
 * @createDate 2024/10/16 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Slf4j
@Component  // 声明为Spring IOC容器管理的Bean
class AliOSSUtils {
    private val keyRepository: KeyRepository = KeyRepository()
    private val endpoint = keyRepository.endpoint
    private val accessKeyId = keyRepository.accessKeyId
    private val accessKeySecret = keyRepository.accessKeySecret
    @Value("\${aliyun.oss.bucket-name}")
    private var bucketName: String? = null
    private val logger: Logger? = LoggerFactory.getLogger(AliOSSUtils::class.java)

    /*
     * function: 上传文件到OSS
     * @param file: MultipartFile 文件对象
     * @return: String 上传成功的url
     */
    fun upload(file: MultipartFile, dir: String = "exampledir/"): String {
        // 获取上传的文件输出流
        file.inputStream.use {
            val originalFileName = file.originalFilename
            if (originalFileName == null || originalFileName.isEmpty()) {
                logger?.error("upload() | 获取不到文件名")
                return "upload() | Error --> 获取不到文件名"
            }
            // 构造拼接新的文件名
            val uuidFileName =
                dir.plus(UUID.randomUUID()
                    .toString()
                    .plus(originalFileName.substring(originalFileName.lastIndexOf("."))))

            // 上传文件到OSS
            val ossClient = OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret)
            ossClient.putObject(bucketName, uuidFileName, it)

            val url: String = endpoint
                .split("//")[0]
                .plus("//")
                .plus(bucketName)
                .plus(".")
                .plus(endpoint.split("//")[1])
                .plus("/")
                .plus(uuidFileName)
            logger?.info("upload() | 文件上传成功，url: $url")

            ossClient.shutdown()
            return url
        }
    }

    fun getBucketName(): String {
        return bucketName?: "BucketName is null"
    }
}