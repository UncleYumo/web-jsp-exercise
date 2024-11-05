package com.example.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author uncle_yumo
 * @fileName Cart
 * @createDate 2024/10/23 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Goods> goodsList = new ArrayList<Goods>();
    public ArrayList<Goods> getGoodsList() {
        return goodsList;
    }
    public void setGoodsList(ArrayList<Goods> goodsList) {
        this.goodsList = goodsList;
    }
    public int getGcount() {
        int count = 0;
        for (Goods goods : goodsList) {
            count += goods.getGcount();
        }
        return count;
    }

    public double getTotal() {
        double sum = 0;
        for (Goods goods : goodsList) {
            sum += goods.getGprice() * goods.getGcount();
        }
        return sum;
    }

    public int check(int gid) {
        int index = -1;
        for (Goods goods : goodsList) {
            if (goods.getGid() == gid) {
                index = goodsList.indexOf(goods);
                break;
            }
        }
        return index;
    }

    public void addGoods(Goods goods) {
        int gid = goods.getGid();
        int index = check(gid);
        if (index == -1) {
            goodsList.add(goods);
        } else {
            int num = goodsList.get(index).getGcount() + goods.getGcount();
            goodsList.get(index).setGcount(num);
        }
    }

}
