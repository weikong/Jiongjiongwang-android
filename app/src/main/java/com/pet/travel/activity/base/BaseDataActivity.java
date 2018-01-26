package com.pet.travel.activity.base;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import java.util.List;

/**
 * Created by kongwei on 2017/2/16.
 */

public class BaseDataActivity extends FragmentActivity {
    protected String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected String getNowActivityName() {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> runningTasks = manager.getRunningTasks(1);
        ActivityManager.RunningTaskInfo cinfo = runningTasks.get(0);
        ComponentName component = cinfo.topActivity;
        return component.getShortClassName();
    }

    /**
     * 发送广播
     */
    private void sendBroadcast(String broad) {
        Intent intent = new Intent();
        intent.setAction(broad);
        sendBroadcast(intent);
    }

    protected void intentToActivity(Class c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }

    protected void intentExtraToActivity(Class c, Bundle bundle) {
        Intent intent = new Intent(getApplicationContext(), c);
        intent.putExtra("Bundle", bundle);
        startActivity(intent);
    }
}
