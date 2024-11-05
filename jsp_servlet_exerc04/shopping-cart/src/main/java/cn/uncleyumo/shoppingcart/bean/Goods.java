package cn.uncleyumo.shoppingcart.bean;

import java.io.Serializable;

/**
 * @author uncle_yumo
 * @fileName Goods
 * @createDate 2024/11/5 November
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public class Goods implements Serializable {
    private static final long serialVersionUID = 1L;
    private int gid;
    private String gname;
    private double gprice;
    private int gcount;

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public double getGprice() {
        return gprice;
    }

    public void setGprice(double gprice) {
        this.gprice = gprice;
    }

    public int getGcount() {
        return gcount;
    }

    public void setGcount(int gcount) {
        this.gcount = gcount;
    }
}
