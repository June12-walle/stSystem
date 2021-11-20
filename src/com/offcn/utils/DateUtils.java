package com.offcn.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	//日期转字符串
	public static String dateToString(Date dt) {
		return sdf.format(dt);
	}
	//字符串转日期
	public static Date  stringToDate(String str) {
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
