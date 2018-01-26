package com.pet.travel.view.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.pet.travel.R;

/**
 * Created by xinzhendi-031 on 2018/1/26.
 */
public class HomeYiQiWanView extends RelativeLayout {

    private LinearLayout layout1, layout2, layout3, layout4, layout5;

    public HomeYiQiWanView(Context context) {
        super(context);
        initView(context);
    }

    public HomeYiQiWanView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public HomeYiQiWanView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View View = LayoutInflater.from(context).inflate(R.layout.view_home_yiqiwan, this);
    }

    public void setData(Object object) {

    }
}
