package com.pet.travel.view.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pet.travel.R;
import com.pet.travel.bean.ProductBean;

import java.util.List;

/**
 * Created by xinzhendi-031 on 2018/1/26.
 */
public class Item4View extends LinearLayout implements View.OnClickListener {

    private LinearLayout layout1, layout2, layout3, layout4;
    private TextView tv_title1, tv_title2, tv_title3, tv_title4;
    private TextView tv_desc1, tv_desc2, tv_desc3, tv_desc4;
    private ImageView iv1, iv2, iv3, iv4;

    public Item4View(Context context) {
        super(context);
        initView(context);
    }

    public Item4View(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public Item4View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View View = LayoutInflater.from(context).inflate(R.layout.view_item_two, this);
        layout1 = (LinearLayout) View.findViewById(R.id.layout_1);
        layout2 = (LinearLayout) View.findViewById(R.id.layout_2);
        layout3 = (LinearLayout) View.findViewById(R.id.layout_3);
        layout4 = (LinearLayout) View.findViewById(R.id.layout_4);
        tv_title1 = (TextView) View.findViewById(R.id.tv_title1);
        tv_title2 = (TextView) View.findViewById(R.id.tv_title2);
        tv_title3 = (TextView) View.findViewById(R.id.tv_title3);
        tv_title4 = (TextView) View.findViewById(R.id.tv_title4);
        tv_desc1 = (TextView) View.findViewById(R.id.tv_desc1);
        tv_desc2 = (TextView) View.findViewById(R.id.tv_desc2);
        tv_desc3 = (TextView) View.findViewById(R.id.tv_desc3);
        tv_desc4 = (TextView) View.findViewById(R.id.tv_desc4);
        iv1 = (ImageView) View.findViewById(R.id.iv_1);
        iv2 = (ImageView) View.findViewById(R.id.iv_2);
        iv3 = (ImageView) View.findViewById(R.id.iv_3);
        iv4 = (ImageView) View.findViewById(R.id.iv_4);
        layout1.setOnClickListener(this);
        layout2.setOnClickListener(this);
        layout3.setOnClickListener(this);
        layout4.setOnClickListener(this);
    }

    public void setData(List<ProductBean> list) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_1:
                break;
            case R.id.layout_2:
                break;
            case R.id.layout_3:
                break;
            case R.id.layout_4:
                break;
        }
    }
}
