package com.example.bean

import java.io.Serializable

/**
 * @author uncle_yumo
 * @fileName Goods
 * @createDate 2024/10/23 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

class Goods(
    private var gid: Int?,
    private var gname: String?,
    private var gprice: Double?,
    private var gcount: Int?
) : Serializable {  // 实现Serializable接口，使其可以被序列化
    companion object {
        const val serialVersionUID = 1L
        fun getSerialVersionUID() = serialVersionUID
    }
    // 构造函数
    constructor() : this(null, null, null, null)
    constructor(gid: Int, gname: String, gprice: Double) : this(gid, gname, gprice, 0)
    // getter方法
    fun getGid() = gid
    fun getGname() = gname
    fun getGprice() = gprice
    fun getGcount() = gcount
    // setter方法
    fun setGid(gid: Int) {
        this.gid = gid
    }
    fun setGname(gname: String) {
        this.gname = gname
    }
    fun setGprice(gprice: Double) {
        this.gprice = gprice
    }
    fun setGcount(gcount: Int) {
        this.gcount = gcount
    }
}