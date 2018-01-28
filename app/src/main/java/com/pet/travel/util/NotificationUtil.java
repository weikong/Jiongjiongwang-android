package com.pet.travel.util;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.pet.travel.R;
import com.pet.travel.activity.MainActivity;


/**
 * Created by xinzhendi-031 on 2016/12/28.
 */
public class NotificationUtil {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void forceNotification(Context context, String distance, String useTime) {
        Intent intent = new Intent();
        intent.setClass(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationManager mNotifiManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification noti = new Notification.Builder(context)
                .setContentTitle("距离：" + distance + " km")
                .setContentText("用时：" + useTime)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .build();
        mNotifiManager.notify(1, noti);
    }

    public static void cancleNotification(Context context) {
        NotificationManager mNotifiManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotifiManager.cancelAll();
    }
}
