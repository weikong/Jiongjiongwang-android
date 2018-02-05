package com.pet.travel.bean;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by xinzhendi-031 on 2017/12/13.
 */
public class UrlDrawableBean implements Serializable {
    public int position;
    public Drawable drawable;
    public String filePath;

    public int getPosition() {
        return position;
    }

    public UrlDrawableBean setPosition(int position) {
        this.position = position;
        return this;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public UrlDrawableBean setDrawable(Drawable drawable) {
        this.drawable = drawable;
        return this;
    }

    public String getFilePath() {
        return filePath;
    }

    public UrlDrawableBean setFilePath(String filePath) {
        this.filePath = filePath;
        return this;
    }
}
