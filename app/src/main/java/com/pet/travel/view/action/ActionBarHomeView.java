package com.pet.travel.view.action;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.pet.travel.R;
import com.pet.travel.activity.MainActivity;
import com.pet.travel.activity.ProductCategoryActivity;
import com.pet.travel.activity.WebH5Activity;

/**
 * Created by xinzhendi-031 on 2018/1/26.
 */
public class ActionBarHomeView extends RelativeLayout implements View.OnClickListener {

    private ImageView ivScan;
    private RelativeLayout layoutSearch;
    private ImageView tvFenlei;

    public ActionBarHomeView(Context context) {
        super(context);
        initView(context);
    }

    public ActionBarHomeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ActionBarHomeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View View = LayoutInflater.from(context).inflate(R.layout.view_action_bar_home, this);
        ivScan = (ImageView) View.findViewById(R.id.iv_action_scan);
        layoutSearch = (RelativeLayout) View.findViewById(R.id.layout_action_search);
        tvFenlei = (ImageView) View.findViewById(R.id.tv_action_fenlei);
        tvFenlei.setColorFilter(getContext().getResources().getColor(R.color.color_ffffff));
        ivScan.setOnClickListener(this);
        layoutSearch.setOnClickListener(this);
        tvFenlei.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_action_scan:
                if (getContext() instanceof MainActivity){
                    Intent intent = new Intent(getContext(), WebH5Activity.class);
                    getContext().startActivity(intent);
                }
                break;
            case R.id.layout_action_search:
                break;
            case R.id.tv_action_fenlei:
                if (getContext() instanceof MainActivity){
                    Intent intent = new Intent(getContext(), ProductCategoryActivity.class);
                    getContext().startActivity(intent);
                }
                break;
        }
    }
}
