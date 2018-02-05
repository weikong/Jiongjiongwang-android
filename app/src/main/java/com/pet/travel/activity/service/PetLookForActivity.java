package com.pet.travel.activity.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.pet.travel.R;
import com.pet.travel.activity.base.BaseUIActivity;

/**
 * 宠物寻找
 * */
public class PetLookForActivity extends BaseUIActivity {

    public static void startActivity(Context context){
        Intent intent = new Intent(context,PetLookForActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_lookfor);
    }
}
