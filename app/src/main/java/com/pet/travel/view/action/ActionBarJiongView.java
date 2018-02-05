package com.pet.travel.view.action;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pet.travel.R;

/**
 * Created by xinzhendi-031 on 2018/1/26.
 */
public class ActionBarJiongView extends RelativeLayout {

    private ImageView ivBack;
    private TextView tvTitle;

    public ActionBarJiongView(Context context) {
        super(context);
        initView(context);
    }

    public ActionBarJiongView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ActionBarJiongView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_action_bar_jiong, this);
        ivBack = (ImageView) view.findViewById(R.id.iv_back);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        ivBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity) getContext()).finish();
            }
        });
    }

    public ActionBarJiongView setTvTitle(String title) {
        if (tvTitle != null)
            tvTitle.setText(title);
        return this;
    }
}
