package com.pet.travel.view.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pet.travel.R;
import com.pet.travel.bean.ProductCategoryBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinzhendi-031 on 2018/1/26.
 */
public class Item2View extends LinearLayout implements View.OnClickListener {

    private LinearLayout layout1, layout2;
    private TextView tv_title_l, tv_desc_l, tv_title_r, tv_desc_r;
    private ImageView iv_l1, iv_l2, iv_r1, iv_r2;
    private List<ProductCategoryBean> datas = new ArrayList<>();

    public Item2View(Context context) {
        super(context);
        initView(context);
    }

    public Item2View(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public Item2View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View View = LayoutInflater.from(context).inflate(R.layout.view_item_two, this);
        layout1 = (LinearLayout) View.findViewById(R.id.layout_l);
        layout2 = (LinearLayout) View.findViewById(R.id.layout_r);
        tv_title_l = (TextView) View.findViewById(R.id.tv_title_l);
        tv_desc_l = (TextView) View.findViewById(R.id.tv_desc_l);
        tv_title_r = (TextView) View.findViewById(R.id.tv_title_r);
        tv_desc_r = (TextView) View.findViewById(R.id.tv_desc_r);
        iv_l1 = (ImageView) View.findViewById(R.id.iv_l1);
        iv_l2 = (ImageView) View.findViewById(R.id.iv_l2);
        iv_r1 = (ImageView) View.findViewById(R.id.iv_r1);
        iv_r1 = (ImageView) View.findViewById(R.id.iv_r2);
        layout1.setOnClickListener(this);
        layout2.setOnClickListener(this);
    }

    public void setData(List<ProductCategoryBean> list) {
        datas.clear();
        if (list == null && list.size() < 2)
            return;
        datas.addAll(list);
        ProductCategoryBean bean1 = list.get(0);
        ProductCategoryBean bean2 = list.get(1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_l:
                break;
            case R.id.layout_r:
                break;
        }
    }
}
