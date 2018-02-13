package com.pet.travel.activity.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.pet.travel.R;
import com.pet.travel.activity.base.BaseUIActivity;
import com.pet.travel.adapter.PetLookForAdapter;
import com.pet.travel.bean.PetLookforBean;
import com.pet.travel.bean.ResultTaskBean;
import com.pet.travel.config.ServerConfig;
import com.pet.travel.okhttp.HttpTaskUtil;
import com.pet.travel.okhttp.OkHttpClientManager;
import com.pet.travel.view.action.ActionBarJiongView;
import com.squareup.okhttp.Request;

import java.io.IOException;
import java.util.List;

/**
 * 宠物寻找
 * */
public class PetLookForActivity extends BaseUIActivity {

    private ListView listView;
    private PetLookForAdapter adapter;
    private HttpTaskUtil httpTaskUtil;

    public static void startActivity(Context context){
        Intent intent = new Intent(context,PetLookForActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_lookfor);
        ActionBarJiongView actionBar = (ActionBarJiongView)findViewById(R.id.action_bar);
        actionBar.setTvTitle("寻犬启示");
        listView = (ListView)findViewById(R.id.listview);
        adapter = new PetLookForAdapter(this);
        listView.setAdapter(adapter);
        loadDataTask();
    }

    private void loadDataTask(){
        if (httpTaskUtil == null)
            httpTaskUtil = new HttpTaskUtil();
        httpTaskUtil.QueryDataTask(ServerConfig.HTTP_LOOKFOR_QUERY,pageNum,pageSize, new OkHttpClientManager.StringCallback() {
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
                            List<PetLookforBean> list = JSON.parseArray(bean.data, PetLookforBean.class);
                            if (pageNum == 1)
                                adapter.setData(list);
                            else
                                adapter.addData(list);
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
