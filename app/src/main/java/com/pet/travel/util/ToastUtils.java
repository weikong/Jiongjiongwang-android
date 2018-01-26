/*
 * Copyright 2014-2024 setNone. All rights reserved.
 */
package com.pet.travel.util;

import android.content.Context;
import android.widget.Toast;

/**
 * 
 * ToastUtils.java - Toast封装类
 * 
 * @author Kevin.Zhang
 * 
 *         2014-2-24 下午3:05:47
 */
public class ToastUtils {

	/**
	 * Show Toast in short time by system
	 * 
	 * @param context
	 * @param strMsg
	 */
	public static void showMessage(final Context context, final String strMsg) {
		Toast.makeText(context, strMsg, Toast.LENGTH_SHORT).show();
	}

	/**
	 * Show Toast in short time by system
	 * 
	 * @param context
	 * @param resId
	 */
	public static void showMessage(final Context context, final int resId) {
		Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
	}

	/**
	 * Show Toast in long time by system
	 * 
	 * @param context
	 * @param resId
	 */
	public static void showMessageLong(final Context context, final int resId) {
		Toast.makeText(context, resId, Toast.LENGTH_LONG).show();
	}

	/**
	 * Show Toast in long time by system
	 * 
	 * @param context
	 * @param strMsg
	 */
	public static void showMessageLong(final Context context, final String strMsg) {
		Toast.makeText(context, strMsg, Toast.LENGTH_LONG).show();
	}

}
