
package com.pet.travel.view.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import com.pet.travel.R;


/**
 * 实现圆角image
 *
 * @author Administrator
 */
public class FilterColorImageView extends ImageView {

    private int mColor = -1;

    public FilterColorImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    public FilterColorImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public FilterColorImageView(Context context) {
        super(context);
        init(context, null);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray a = null;
        if (attrs != null) {
            a = context.obtainStyledAttributes(attrs, R.styleable.FilterColorImageView);
            mColor = a.getColor(R.styleable.FilterColorImageView_filterColor, mColor);
            setmColor(mColor);
            Log.e("FilterColorImageView", "  mColor = " + mColor);
        }
        if (a != null)
            a.recycle();
    }

    public void setmColor(int color){
        this.mColor = color;
        this.setColorFilter(mColor);
    }

    public void clearmColorFilter(){
        this.clearColorFilter();
    }

}