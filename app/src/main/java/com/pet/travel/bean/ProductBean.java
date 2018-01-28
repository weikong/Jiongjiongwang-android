package com.pet.travel.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kongwei on 2017/2/15.
 */

public class ProductBean implements Serializable {

    public int id;
    private String title;
    private String desc;
    private List<ProductItemBean> items;

    public int getId() {
        return id;
    }

    public ProductBean setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ProductBean setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public ProductBean setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public List<ProductItemBean> getItems() {
        return items;
    }

    public ProductBean setItems(List<ProductItemBean> items) {
        this.items = items;
        return this;
    }
}
