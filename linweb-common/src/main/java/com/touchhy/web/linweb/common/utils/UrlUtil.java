package com.touchhy.web.linweb.common.utils;

public class UrlUtil {
	private static StringBuffer buffer;
	private static boolean flag = true;
	public static void setPath(String path){
		buffer = new StringBuffer();
		flag = true;
		buffer.append(path);
	}
	public static void setQueryData(String key,String value){
		if(flag){
			buffer.append("?");
		}
	}
}
