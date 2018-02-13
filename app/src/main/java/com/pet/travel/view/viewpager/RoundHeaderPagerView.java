package com.pet.travel.view.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.pet.travel.R;
import com.pet.travel.adapter.BaseViewPagerAdapter;
import com.pet.travel.bean.PetDatingBean;
import com.pet.travel.config.ServerConfig;
import com.pet.travel.util.DisplayUtil;
import com.pet.travel.util.ImageLoaderOptions;
import com.pet.travel.util.UITools;
import com.pet.travel.view.imageview.RoundAngleImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinzhendi-031 on 2018/1/26.
 */
public class RoundHeaderPagerView extends RelativeLayout {

    private ViewPager viewPager;
    private BaseViewPagerAdapter adapter;
    private int currentPage = 0;

    public RoundHeaderPagerView(Context context) {
        super(context);
        initView(context);
    }

    public RoundHeaderPagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public RoundHeaderPagerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View View = LayoutInflater.from(context).inflate(R.layout.view_round_headerpager, this);
        viewPager = (ViewPager) View.findViewById(R.id.viewpager);
        viewPager.setPageMargin(DisplayUtil.dp2px(4));
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
    }

    public void loadData(PetDatingBean bean) {
        List<View> list = new ArrayList<>();
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, UITools.dip2px(getContext(), 160));
        LayoutInflater inflater = LayoutInflater.from(getContext());
        String url = "";
        String[] urls = null;
        if (bean != null){
            url = bean.getHeadurl();
            if (!TextUtils.isEmpty(url))
                urls = url.split(",");
        }
        if (urls == null || urls.length == 0)
            urls = new String[1];
        for (int i = 0; i < urls.length; i++) {
            View view = inflater.inflate(R.layout.view_round_image,null);
            RoundAngleImageView imageView = (RoundAngleImageView) view.findViewById(R.id.dialog_pet_header);
            url = urls[i];
            if (!TextUtils.isEmpty(url) && !url.startsWith("http://"))
                url = String.format(ServerConfig.HTTP_DOWNLOAD_FILE_2, url);
            ImageLoader.getInstance().displayImage(url, imageView, ImageLoaderOptions.optionsAdapterDefault);
            list.add(view);
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
