package com.itheima.pojo

/**
 * 用于封装统一的响应结果
 * @property code 响应码，1 代表成功; 0 代表失败
 * @property msg 响应信息，描述字符串
 * @property data 返回的数据，可以是任意类型
 * @constructor 创建一个 Result_KT 实例
 */

data class Result_KT(
    var code: Int = 0,             // 响应码，默认值为0
    var msg: String = "",          // 响应信息，默认值为空字符串
    var data: Any? = null          // 返回的数据，默认值为null
) {
    companion object {
        fun success(): Result_KT = Result_KT(code = 1, msg = "success")
        fun success(data: Any?): Result_KT = Result_KT(code = 1, msg = "success", data = data)
        fun error(msg: String): Result_KT = Result_KT(code = 0, msg = msg)
    }
}
