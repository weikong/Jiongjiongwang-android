package com.pet.travel.view.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.pet.travel.R;
import com.pet.travel.activity.WebActivity;
import com.pet.travel.activity.service.PetBeautyActivity;
import com.pet.travel.activity.service.PetDatingActivity;
import com.pet.travel.activity.service.PetFosterCareActivity;
import com.pet.travel.activity.service.PetLookForActivity;

/**
 * Created by xinzhendi-031 on 2018/1/26.
 */
public class HomeTabView extends RelativeLayout implements View.OnClickListener {

    private LinearLayout layout1,layout2,layout3,layout4,layout5;

    public HomeTabView(Context context) {
        super(context);
        initView(context);
    }

    public HomeTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public HomeTabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View View = LayoutInflater.from(context).inflate(R.layout.view_home_tab, this);
        layout1 = (LinearLayout) View.findViewById(R.id.layout_tab_1);
        layout2 = (LinearLayout) View.findViewById(R.id.layout_tab_2);
        layout3 = (LinearLayout) View.findViewById(R.id.layout_tab_3);
        layout4 = (LinearLayout) View.findViewById(R.id.layout_tab_4);
        layout5 = (LinearLayout) View.findViewById(R.id.layout_tab_5);
        layout1.setOnClickListener(this);
        layout2.setOnClickListener(this);
        layout3.setOnClickListener(this);
        layout4.setOnClickListener(this);
        layout5.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.layout_tab_1:
                PetBeautyActivity.startActivity(getContext());
                break;
            case R.id.layout_tab_2:
                PetFosterCareActivity.startActivity(getContext());
                break;
            case R.id.layout_tab_3:
                WebActivity.startActivity(getContext());
                break;
            case R.id.layout_tab_4:
                PetDatingActivity.startActivity(getContext());
                break;
            case R.id.layout_tab_5:
                PetLookForActivity.startActivity(getContext());
                break;
        }
    }
}
