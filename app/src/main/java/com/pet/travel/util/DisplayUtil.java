package com.pet.travel.util;

import android.content.Context;
import android.util.TypedValue;
import android.view.WindowManager;

import com.pet.travel.app.App;

import java.lang.reflect.Field;


/**
 * Created by wei.kong
 */
public class DisplayUtil {

    public static int screenWidth = 480;
    public static int screenHeight = 800;

    public static void displayScreen(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        screenWidth = wm.getDefaultDisplay().getWidth();
        screenHeight = wm.getDefaultDisplay().getHeight();
        UITools.init(screenWidth,screenHeight);
    }

    public static int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                App.getInstance().getResources().getDisplayMetrics());
    }

    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

    // 获取手机状态栏高度
    public static int getStatusBarHeight(Context context) {
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, statusBarHeight = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return statusBarHeight;
    }
}
