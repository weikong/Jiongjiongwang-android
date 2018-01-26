package com.pet.travel.view.jiong;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.pet.travel.R;

/**
 * Created by xinzhendi-031 on 2018/1/26.
 */
public class JiongHeaderView extends RelativeLayout {

    private ImageView ivHeaderPet, ivHeaderMe;

    public JiongHeaderView(Context context) {
        super(context);
        initView(context);
    }

    public JiongHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public JiongHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View View = LayoutInflater.from(context).inflate(R.layout.view_jiong_header, this);
        ivHeaderPet = (ImageView) View.findViewById(R.id.iv_header_pet);
        ivHeaderMe = (ImageView) View.findViewById(R.id.iv_header_me);
    }
}
