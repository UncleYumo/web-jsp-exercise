package cn.uncleyumo.shoppingcart.dao

import cn.uncleyumo.shoppingcart.bean.Goods


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
                    gname = "小米 10"
                    gprice = 3999.00
                }
                1002 -> {
                    setGid(1002)
                    gname = "红米 K30"
                    gprice = 1999.00
                }
                1003 -> {
                    setGid(1003)
                    gname = "红米 Note8"
                    gprice = 999.00
                }
                1004 -> {
                    setGid(1004)
                    gname = "华为 Mate30"
                    gprice = 3699.00
                }
                1005 -> {
                    setGid(1005)
                    gname = "华为 P40"
                    gprice = 4188.00
                }
                1006 -> {
                    setGid(1006)
                    gname = "华为 Nova6"
                    gprice = 3499.00
                }
            }
        }
        return goods
    }

}