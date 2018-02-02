package com.pet.travel.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            Message message = Message.obtain();
            message.what = 1;
            message.arg1 = 2;
            handler.sendMessageDelayed(message,1000);
        }
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
                ivJiong.setImageResource(R.mipmap.dog_open_left);
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
                ivJiong.setImageResource(R.mipmap.dog_open);
                viewPager.setCurrentItem(1, false);
                Message message = Message.obtain();
                message.what = 1;
                message.arg1 = 4;
                handler.sendMessageDelayed(message,400);
            }
        });
        layoutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentIndex == 2)
                    return;
                setToolGray();
                ivMe.setColorFilter(getResources().getColor(R.color.color_theme));
                ivJiong.setImageResource(R.mipmap.dog_open_right);
                viewPager.setCurrentItem(2, false);
            }
        });
    }

    private void setToolGray() {
        ivHome.setColorFilter(getResources().getColor(R.color.color_item_text_bg));
        ivJiong.setColorFilter(getResources().getColor(R.color.transparent_99_d));
        ivMe.setColorFilter(getResources().getColor(R.color.color_item_text_bg));
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    int count = msg.arg1;
                    for (int i=0;i<count;i++){
                        if (i == 0)
                            this.sendEmptyMessageDelayed(2,0);
                        else if (i == 1)
                            this.sendEmptyMessageDelayed(3,200);
                        else if (i == 2)
                            this.sendEmptyMessageDelayed(2,400);
                        else if (i == 3)
                            this.sendEmptyMessageDelayed(3,600);
                    }
                    break;
                case 2:
                    ivJiong.setImageResource(R.mipmap.dog_close);
                    break;
                case 3:
                    ivJiong.setImageResource(R.mipmap.dog_open);
                    break;
            }
        }
    };

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
