package cn.uncleyumo.shoppingcart.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author uncle_yumo
 * @fileName Cart
 * @createDate 2024/11/5 November
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;  // 序列化ID
    private ArrayList<Goods> goodsList = new ArrayList<Goods>();  // 商品列表

    public ArrayList<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(ArrayList<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    // 获取购物车总数量
    public int getCount() {
        int count = 0;
        for (Goods good : goodsList) {
            count += good.getGcount();
        }
        return count;
    }

    public double getTotal() {
        double sum = 0;
        for (Goods good : goodsList) {
            sum += good.getGcount() * good.getGprice();
        }
        return sum;
    }

    // 判断是否存在gid对应的商品
    public int check(int gid) {
        int index = -1;
        for (Goods good : goodsList) {
            if (good.getGid() == gid) {
                index = goodsList.indexOf(good);
                break;
            }
        }
        return index;
    }

    public void addGoods(Goods goods) {
        int gid = goods.getGid();
        if (check(gid) == -1) {
            goodsList.add(goods);
        } else {
            int num = goodsList.get(check(gid)).getGcount() + goods.getGcount();
            goodsList.get(check(gid)).setGcount(num);
        }
    }

    public void deleteGoods(int gid) {
        if (check(gid) == -1) return;
        goodsList.remove(check(gid));
    }
}
