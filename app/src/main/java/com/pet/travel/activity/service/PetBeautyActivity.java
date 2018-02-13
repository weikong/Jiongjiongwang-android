package com.pet.travel.activity.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.pet.travel.R;
import com.pet.travel.activity.base.BaseUIActivity;
import com.pet.travel.adapter.BaseViewPagerAdapter;
import com.pet.travel.bean.PetServiceBean;
import com.pet.travel.bean.ResultTaskBean;
import com.pet.travel.config.ServerConfig;
import com.pet.travel.okhttp.HttpTaskUtil;
import com.pet.travel.okhttp.OkHttpClientManager;
import com.pet.travel.util.ImageLoaderOptions;
import com.pet.travel.view.action.ActionBarJiongView;
import com.pet.travel.view.imageview.RoundAngleImageView;
import com.squareup.okhttp.Request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 宠物美容
 */
public class PetBeautyActivity extends BaseUIActivity {

//    private ListView listView;
//    private PetBeautyAdapter adapter;

    private ViewPager viewPager;
    private BaseViewPagerAdapter adapter;

    private HttpTaskUtil httpTaskUtil;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, PetBeautyActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_beauty);
        ActionBarJiongView actionBar = (ActionBarJiongView) findViewById(R.id.action_bar);
        actionBar.setTvTitle("美容");
//        listView = (ListView)findViewById(R.id.listview);
//        adapter = new PetBeautyAdapter(this);
//        listView.setAdapter(adapter);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new BaseViewPagerAdapter();
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        loadDataTask();
    }

    private void loadDataTask() {
        if (httpTaskUtil == null)
            httpTaskUtil = new HttpTaskUtil();
        httpTaskUtil.QueryPetServiceTask(8, new OkHttpClientManager.StringCallback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(String response) {
                try {
                    ResultTaskBean bean = JSON.parseObject(response, ResultTaskBean.class);
                    if (bean != null && bean.code == 1) {
                        if (!TextUtils.isEmpty(bean.data)) {
                            List<PetServiceBean> list = JSON.parseArray(bean.data, PetServiceBean.class);
//                            adapter.setData(list);
//                            adapter.notifyDataSetChanged();

                            List<View> listView = new ArrayList<>();
                            LayoutInflater inflater = LayoutInflater.from(PetBeautyActivity.this);
                            for (int i = 0; list != null && i < list.size(); i++) {
                                View view = inflater.inflate(R.layout.view_pet_beauty_item, null);
                                RoundAngleImageView imageView = (RoundAngleImageView) view.findViewById(R.id.dialog_pet_header);
                                String url = list.get(i).getThumb();
                                if (!TextUtils.isEmpty(url) && !url.startsWith("http://"))
                                    url = String.format(ServerConfig.HTTP_DOWNLOAD_FILE_2, url);
                                ImageLoader.getInstance().displayImage(url, imageView, ImageLoaderOptions.optionsAdapterDefault);
                                listView.add(view);
                            }
                            adapter.setViewList(listView);
                            adapter.notifyDataSetChanged();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
