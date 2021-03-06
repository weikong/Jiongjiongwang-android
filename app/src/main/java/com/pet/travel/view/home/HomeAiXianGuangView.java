package com.pet.travel.view.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.pet.travel.R;
import com.pet.travel.bean.ProductCategoryBean;

import java.util.List;

/**
 * Created by xinzhendi-031 on 2018/1/26.
 */
public class HomeAiXianGuangView extends RelativeLayout {

    private LinearLayout layout_content;

    public HomeAiXianGuangView(Context context) {
        super(context);
        initView(context);
    }

    public HomeAiXianGuangView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public HomeAiXianGuangView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View View = LayoutInflater.from(context).inflate(R.layout.view_home_aixianguang, this);
        layout_content = (LinearLayout) View.findViewById(R.id.layout_content);
    }

    public void setData(List<ProductCategoryBean> list) {
        layout_content.removeAllViews();
        if (list == null || list.size() == 0)
            return;
        Item2View item2View1 = new Item2View(getContext());
        Item2View item2View2 = new Item2View(getContext());
        item2View1.setData(list.subList(0,2));
        item2View1.setData(list.subList(2,4));
        layout_content.addView(item2View1);
        layout_content.addView(item2View2);
    }
}
