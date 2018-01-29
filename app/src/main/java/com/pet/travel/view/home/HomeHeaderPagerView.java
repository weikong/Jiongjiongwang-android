package com.pet.travel.view.home;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.pet.travel.R;
import com.pet.travel.adapter.BaseViewPagerAdapter;
import com.pet.travel.util.UITools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinzhendi-031 on 2018/1/26.
 */
public class HomeHeaderPagerView extends RelativeLayout {

    private ViewPager viewPager;
    private BaseViewPagerAdapter adapter;
    private int currentPage = 0;

    public HomeHeaderPagerView(Context context) {
        super(context);
        initView(context);
    }

    public HomeHeaderPagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public HomeHeaderPagerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View View = LayoutInflater.from(context).inflate(R.layout.view_home_headerpager, this);
        viewPager = (ViewPager) View.findViewById(R.id.viewpager);
        adapter = new BaseViewPagerAdapter();
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(currentPage);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        loadData();
    }

    public void loadData() {
        List<ImageView> list = new ArrayList<>();
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, UITools.dip2px(getContext(), 160));
        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(params);
            imageView.setImageResource(R.mipmap.bg_guide_p1);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            list.add(imageView);
        }
        adapter.setViewList(list);
        adapter.notifyDataSetChanged();
    }

    public void autoChangeCurrentPage() {
        try {
            if (adapter.getCount() > 0) {
                if (currentPage >= adapter.getCount() - 1)
                    currentPage = 0;
                else
                    currentPage++;
                viewPager.setCurrentItem(currentPage);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
