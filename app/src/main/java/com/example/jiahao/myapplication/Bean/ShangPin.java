package com.example.jiahao.myapplication.Bean;

/**
 * Created by Jiahao on 2016/7/21.
 */
public class ShangPin {
    String name;
    String shangjia;
    String price;
    String beizhu;

    public ShangPin(String name, String shangjia, String price, String beizhu) {
        this.name = name;
        this.shangjia = shangjia;
        this.price = price;
        this.beizhu = beizhu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShangjia() {
        return shangjia;
    }

    public void setShangjia(String shangjia) {
        this.shangjia = shangjia;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }
}
