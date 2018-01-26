package com.pet.travel.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import com.pet.travel.R;

/**
 * Created by kongwei on 2017/2/14.
 */

public class AndroidOSInfoManager {
    /**
     * 手机型号
     * HUAWEI Y635-CL00
     */
    public static String AOsModel() {
        String s = android.os.Build.MODEL;
        return s;
    }

    public static String AOsSDK() {
        String s = Build.VERSION.SDK;
        return s;
    }

    public static String AOsCodeName() {
        String s = Build.VERSION.CODENAME;
        return s;
    }

    public static String AOsType() {
        String s = Build.TYPE;
        return s;
    }

    /**
     * 手机产商
     * HUAWEI
     */
    public static String AOsManufacturer() {
        String s = Build.MANUFACTURER.toUpperCase();
        return s;
    }

    /**
     * 获取版本号
     *
     * @return 当前应用的版本号
     */
    public static String getAppVersion(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            String version = info.versionName;
            return context.getString(R.string.version_name) + version;
        } catch (Exception e) {
            e.printStackTrace();
            return context.getString(R.string.can_not_find_version_name);
        }
    }
}
