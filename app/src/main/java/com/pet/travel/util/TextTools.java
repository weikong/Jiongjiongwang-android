package com.pet.travel.util;

import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextTools {
	/**
	 * Whether the e-mail address
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(email);
		return m.matches();
	}

	/**
	 * 验证是否为手机号码
	 * 
	 * @param no
	 * @return
	 */
	public static boolean isTel(String tel) {
		// String reg = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
//		String reg = "1[0-9]{10}";
		String reg = "[0-9]+";
		return tel.matches(reg);
	}

	/**
	 * 返回输入文本内容
	 * 
	 * @return
	 */
	public static String formateTelText(String tel) {
		if (TextUtils.isEmpty(tel))
			return null;
		return tel.replaceAll("[^0-9]", "");
	}

	public static String replace(int start, int end, String str, String target) {
		if (str.length() - end <= start)
			return str;
		StringBuffer sb = new StringBuffer();
		String preStr = str.substring(0, start);
		sb.append(preStr);

		String content = str.substring(start, str.length() - end);
		sb.append(content.replaceAll("[a-zA-Z0-9]", target));

		String suffix = str.substring(str.length() - end);
		sb.append(suffix);

		return sb.toString();
	}

	/**
	 * The cursor position is set to the text of the tail EditText
	 * 
	 * @param et
	 */
	public static void setEditTextEndSelection(EditText et) {
		CharSequence text = et.getText();
		if (text instanceof Spannable) {
			Spannable spanText = (Spannable) text;
			Selection.setSelection(spanText, text.length());
		}
	}

	public static String buildIntParams(String p) {
		return TextUtils.isEmpty(p) ? "0" : p;
	}

	public static String buildStringParams(String p, String def) {
		return TextUtils.isEmpty(p) ? def : p;
	}

	public static String buildDateParams(long time) {
		return null;
	}
}
