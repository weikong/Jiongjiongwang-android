package com.pet.travel.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * @Title: UnTouchViewPager.java 
 * @Package com.melink.android.ui.view.viewpager 
 * @Description 不可点击的viewpager
 * @date 2015-5-11 下午9:32:22   
 * @author shun
 * @version V1.0  
 */
public class UnTouchViewPager extends ViewPager {

    public UnTouchViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UnTouchViewPager(Context context) {
        super(context);
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        return false;
    }
    
    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        return false;
    }
    
    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item);
    }
}
