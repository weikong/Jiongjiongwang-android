package com.pet.travel.activity.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.pet.travel.R;
import com.pet.travel.activity.base.BaseUIActivity;
import com.pet.travel.adapter.PetDatingAdapter;
import com.pet.travel.bean.PetDatingBean;
import com.pet.travel.bean.ResultTaskBean;
import com.pet.travel.config.ServerConfig;
import com.pet.travel.okhttp.HttpTaskUtil;
import com.pet.travel.okhttp.OkHttpClientManager;
import com.squareup.okhttp.Request;

import java.io.IOException;
import java.util.List;

/**
 * 宠物约会
 * */
public class PetDatingActivity extends BaseUIActivity {

    private ListView listView;
    private PetDatingAdapter adapter;
    private HttpTaskUtil httpTaskUtil;

    public static void startActivity(Context context){
        Intent intent = new Intent(context,PetDatingActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_dating);
        listView = (ListView)findViewById(R.id.listview);
        adapter = new PetDatingAdapter(this);
        listView.setAdapter(adapter);
        loadDataTask();
    }

    private void loadDataTask(){
        if (httpTaskUtil == null)
            httpTaskUtil = new HttpTaskUtil();
        httpTaskUtil.QueryDataTask(ServerConfig.HTTP_DATING_QUERY,pageNum,pageSize, new OkHttpClientManager.StringCallback() {
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
                            List<PetDatingBean> list = JSON.parseArray(bean.data, PetDatingBean.class);
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
