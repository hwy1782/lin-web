package com.touchhy.web.linweb.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat();
	public static String transform(Date date,String pattern){
		sdf.applyPattern(pattern);
		return sdf.format(date);
	}
}
