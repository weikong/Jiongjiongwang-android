package com.pet.travel.view.action;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.pet.travel.R;

/**
 * Created by xinzhendi-031 on 2018/1/26.
 */
public class ActionBarJiongView extends RelativeLayout {

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
        View View = LayoutInflater.from(context).inflate(R.layout.view_action_bar_jiong, this);
    }
}
