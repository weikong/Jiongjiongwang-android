package com.pet.travel.util;

import android.content.Context;

public class UITools {
    private final static String TAG = "UITools";

    /**
     * Device pixels
     */
    public static int SCREEN_WIDTH = 480;
    public static int SCREEN_HEIGHT = 800;
    private static final int DESIGN_WIDTH = 480;
    private static final int DESIGN_HEIGHT = 800;
    /**
     * Pixel density
     */
    public static float mainScale = 1.0f;

    public static void init(int screenWidth, int srceenHeight) {
        SCREEN_WIDTH = screenWidth;
        SCREEN_HEIGHT = srceenHeight;
        mainScale = Math.min(1f * SCREEN_HEIGHT / DESIGN_HEIGHT, 1f * SCREEN_WIDTH / DESIGN_WIDTH);
    }

    /**
     * According to the resolution of the mobile phone unit from dp turn become px (pixels)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * According to the phone's resolution from px (pixels) of the units will become a dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * Convert px value sp value, to ensure constant text size
     * 
     * @param pxValue
     *            （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * Convert sp value px value, to ensure constant text size
     * 
     * @param spValue
     *            （DisplayMetrics Class attribute scaledDensity）
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

}
