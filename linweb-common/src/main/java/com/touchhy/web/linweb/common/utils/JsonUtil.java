package com.touchhy.web.linweb.common.utils;

import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.StringUtils;

public class JsonUtil {

	/**
	 * 转换成json格式的字符串
	 * 
	 * @param string
	 * @return
	 */
	public static String quote(String string) {
		if (string == null || string.length() == 0) {
			return "";
		}

		char b;
		char c = 0;
		int i;
		int len = string.length();
		StringBuffer sb = new StringBuffer(len + 4);
		String t;

		for (i = 0; i < len; i += 1) {
			b = c;
			c = string.charAt(i);
			switch (c) {
			case '\\':
			case '"':
				sb.append('\\');
				sb.append(c);
				break;
			case '/':
				if (b == '<') {
					sb.append('\\');
				}
				sb.append(c);
				break;
			case '\b':
				sb.append("\\b");
				break;
			case '\t':
				sb.append("\\t");
				break;
			case '\n':
				sb.append("\\n");
				break;
			case '\f':
				sb.append("\\f");
				break;
			case '\r':
				sb.append("\\r");
				break;
			default:
				if (c < ' ') {
					t = "000" + Integer.toHexString(c);
					sb.append("\\u").append(t.substring(t.length() - 4));
				} else {
					sb.append(c);
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 把双引号和单引号转义为\\u的形式
	 * 
	 * @param string
	 * @return
	 */
	public static String unicode(String string) {
		if (StringUtils.isNotEmpty(string)) {
			StringBuilder sb = new StringBuilder(string.length() * 6);
			char c = 0;
			for (int i = 0; i < string.length(); i++) {
				c = string.charAt(i);
				if ('\'' == c || '"' == c || '&' == c) {
					sb.append(CharUtils.unicodeEscaped(string.charAt(i)));
				} else {
					sb.append(c);
				}
			}
			return sb.toString();
		}
		return "";
	}

}

