package com.pet.travel.view.action;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pet.travel.R;
import com.pet.travel.util.ToastUtils;

/**
 * Created by xinzhendi-031 on 2018/1/26.
 */
public class ActionBarHomeView extends RelativeLayout implements View.OnClickListener {

    private ImageView ivScan;
    private RelativeLayout layoutSearch;
    private TextView tvFenlei;

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
        tvFenlei = (TextView) View.findViewById(R.id.tv_action_fenlei);
        ivScan.setOnClickListener(this);
        layoutSearch.setOnClickListener(this);
        tvFenlei.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_action_scan:
                ToastUtils.showMessage(getContext(), "scan");
                break;
            case R.id.layout_action_search:
                ToastUtils.showMessage(getContext(), "search");
                break;
            case R.id.tv_action_fenlei:
                ToastUtils.showMessage(getContext(), "fenlei");
                break;
        }
    }
}
