package com.pet.travel.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.pet.travel.R;
import com.pet.travel.activity.base.BaseUIActivity;
import com.pet.travel.fragment.HomeFragment;
import com.pet.travel.fragment.JiongFragment;
import com.pet.travel.fragment.MeFragment;
import com.pet.travel.view.UnTouchViewPager;

public class MainActivity extends BaseUIActivity {

    private HomeFragment homeFragment;
    private MeFragment meFragment;
    private JiongFragment jiongFragment;
    private UnTouchViewPager viewPager;
    private FloatingActionButton fab;
    private LinearLayout layoutHome, layoutJiong, layoutMe;
    private ImageView ivHome, ivJiong, ivMe;
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        layoutHome = (LinearLayout) findViewById(R.id.layout_home);
        layoutJiong = (LinearLayout) findViewById(R.id.layout_jiong);
        layoutMe = (LinearLayout) findViewById(R.id.layout_me);
        ivHome = (ImageView) findViewById(R.id.iv_home);
        ivJiong = (ImageView) findViewById(R.id.iv_jiong);
        ivMe = (ImageView) findViewById(R.id.iv_me);
        setToolGray();
        ivJiong.clearColorFilter();
        viewPager = (UnTouchViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        viewPager.addOnPageChangeListener(pageChangeListener);
        viewPager.setCurrentItem(1);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        layoutHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentIndex == 0)
                    return;
                setToolGray();
                ivHome.setColorFilter(getResources().getColor(R.color.color_theme));
                viewPager.setCurrentItem(0, false);
            }
        });
        layoutJiong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentIndex == 1)
                    return;
                setToolGray();
                ivJiong.clearColorFilter();
                viewPager.setCurrentItem(1, false);
            }
        });
        layoutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentIndex == 2)
                    return;
                setToolGray();
                ivMe.setColorFilter(getResources().getColor(R.color.color_theme));
                viewPager.setCurrentItem(2, false);
            }
        });
    }

    private void setToolGray() {
        ivHome.setColorFilter(getResources().getColor(R.color.color_item_text_bg));
        ivJiong.setColorFilter(getResources().getColor(R.color.transparent_99_d));
        ivMe.setColorFilter(getResources().getColor(R.color.color_item_text_bg));
    }

    /**
     * 初始化FragmentPagerAdapter
     */
    private FragmentPagerAdapter adapter = new FragmentPagerAdapter(
            getSupportFragmentManager()) {

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    if (homeFragment == null)
                        homeFragment = new HomeFragment();
                    return homeFragment;
                case 1:
                    if (jiongFragment == null)
                        jiongFragment = new JiongFragment();
                    return jiongFragment;
                case 2:
                    if (meFragment == null)
                        meFragment = new MeFragment();
                    return meFragment;
                default:
                    if (homeFragment == null)
                        homeFragment = new HomeFragment();
                    return homeFragment;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    };

    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            currentIndex = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}