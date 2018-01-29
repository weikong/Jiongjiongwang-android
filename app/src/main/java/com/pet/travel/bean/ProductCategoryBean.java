package com.pet.travel.bean;

import java.io.Serializable;

/**
 * Created by kongwei on 2017/2/15.
 */

public class ProductCategoryBean implements Serializable {

    public int id;
    private String title;
    private String desc;
    private String cover;
    private String type;

    public int getId() {
        return id;
    }

    public ProductCategoryBean setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ProductCategoryBean setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public ProductCategoryBean setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public String getCover() {
        return cover;
    }

    public ProductCategoryBean setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public String getType() {
        return type;
    }

    public ProductCategoryBean setType(String type) {
        this.type = type;
        return this;
    }
}
