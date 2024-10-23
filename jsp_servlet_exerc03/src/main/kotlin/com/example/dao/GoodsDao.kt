package com.example.dao

import com.example.bean.Goods

/**
 * @author uncle_yumo
 * @fileName GoodsDao
 * @createDate 2024/10/23 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

open class GoodsDao {

    open fun setGoods(gid: Int): Goods {
        val goods: Goods = Goods().apply {
            when (gid) {
                1001 -> {
                    setGid(1001)
                    setGname("小米 10")
                    setGprice(3999.00)
                }
                1002 -> {
                    setGid(1002)
                    setGname("红米 K30")
                    setGprice(1999.00)
                }
                1003 -> {
                    setGid(1003)
                    setGname("红米 Note8")
                    setGprice(999.00)
                }
                1004 -> {
                    setGid(1004)
                    setGname("华为 Mate30")
                    setGprice(3699.00)
                }
                1005 -> {
                    setGid(1005)
                    setGname("华为 P40")
                    setGprice(4188.00)
                }
                1006 -> {
                    setGid(1006)
                    setGname("华为 Nova6")
                    setGprice(3499.00)
                }
            }
        }
        return goods
    }

}