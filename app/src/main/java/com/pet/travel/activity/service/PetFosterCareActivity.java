package com.pet.travel.activity.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.pet.travel.R;
import com.pet.travel.activity.base.BaseUIActivity;
import com.pet.travel.adapter.PetBeautyAdapter;
import com.pet.travel.bean.PetServiceBean;
import com.pet.travel.bean.ResultTaskBean;
import com.pet.travel.okhttp.HttpTaskUtil;
import com.pet.travel.okhttp.OkHttpClientManager;
import com.squareup.okhttp.Request;

import java.io.IOException;
import java.util.List;

/**
 * 宠物寄养
 */
public class PetFosterCareActivity extends BaseUIActivity {

    private ListView listView;
    private PetBeautyAdapter adapter;
    private HttpTaskUtil httpTaskUtil;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, PetFosterCareActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_foster_care);
        listView = (ListView) findViewById(R.id.listview);
        adapter = new PetBeautyAdapter(this);
        listView.setAdapter(adapter);
        loadDataTask();
    }

    private void loadDataTask() {
        if (httpTaskUtil == null)
            httpTaskUtil = new HttpTaskUtil();
        httpTaskUtil.QueryPetServiceTask(27, new OkHttpClientManager.StringCallback() {
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
                            adapter.setData(list);
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
