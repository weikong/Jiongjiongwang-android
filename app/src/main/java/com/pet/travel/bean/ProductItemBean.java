package com.pet.travel.bean;

import java.io.Serializable;

/**
 * Created by kongwei on 2017/2/15.
 */

public class ProductItemBean implements Serializable {

    public int id;
    private String title;
    private String desc;
    private String cover;
    private String price;

    public int getId() {
        return id;
    }

    public ProductItemBean setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ProductItemBean setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public ProductItemBean setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public String getCover() {
        return cover;
    }

    public ProductItemBean setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public ProductItemBean setPrice(String price) {
        this.price = price;
        return this;
    }
}
