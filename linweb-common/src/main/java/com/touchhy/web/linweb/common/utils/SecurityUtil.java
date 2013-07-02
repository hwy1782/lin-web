package com.touchhy.web.linweb.common.utils;


import org.apache.commons.lang.StringEscapeUtils;

public class SecurityUtil extends StringEscapeUtils{


	/**
	 * 对输入的String进行JAVASCRIPT 转义<br />
	 * 返回JAVASCRIPT 转义后的字符串，其中'被转义成\' 其他类似。<br />
	 * 用于JAVASCRIPT环境中的参数预处理<br />
	 * 如：<br />
	 * 		&lt;script&gt;var a = &quot;$SecurityUtil.jsEncode($var)&quot;;&lt;script&gt;<br />
	 * 		&lt;img src=&quot;http://www.taobao.com/logi.jpg&quot; onClick=&quot;check($SecurityUtil.jsEncode($var))&quot; /&gt;
	 * 
	 * @param s -- 输入的待转义的字符串
	 * @return JAVASCRIPT转义后的字符串
	 */
	public static String jsEncode(String s) {
		if (s != null){
			return escapeJavaScript(s);
		}else{
			return null;
		}
	}
	
	/**
	 * 输入Object 先做toString()处理。然后进行JAVASCRIPT 转义<br />
	 * 返回JAVASCRIPT 转义后的字符串，其中'被转义成\' 其他类似。<br />
	 * 用于JAVASCRIPT环境中的参数预处理<br />
	 * 如：<br />
	 * 		&lt;script&gt;var a = &quot;$SecurityUtil.jsEncode($var)&quot;;&lt;script&gt;<br />
	 * 		&lt;img src=&quot;http://www.taobao.com/logi.jpg&quot; onClick=&quot;check($SecurityUtil.jsEncode($var))&quot; /&gt;
	 * 
	 * @param s -- 输入的待转义的对象
	 * @return JAVASCRIPT转义后的字符串
	 */
	public static String jsEncode(Object s){
		if(s!=null){
			return jsEncode(s.toString());
		}else{
			return null;
		}
	}

	/**
	 * 输入Object 先做toString()处理，然后进行富文本过滤<br />
     * 移除其中的恶意标签和脚本信息，保留安全的HTML TAG。<br />
	 * 
	 * @param str -- 需要输出为富文本的Object
	 * @return 移除Object中的恶意代码后安全的富文本字符串
	 */
	public static String richtext(Object str) {
		if (str != null){
			return richtext(str.toString());
		}else{
			return null;
		}
	}

	/**
	 * 提供一种例外机制，允许不做任何安全处理直接输出。<br />
	 * 该方法会绕过所有的安全机制，不到万不得已请不要使用
	 * 
	 * @param str -- 输入不需要任何处理 的字符串
	 * @return 原样返回输入字符串
	 */
	public static String ignoretext(String str){
		if (str != null){
			return str;
		}else{
			return null;
		}
	}
	/**
	 * 提供一种例外机制，允许不做任何安全处理直接输出。<br />
	 * 该方法会绕过所有的安全机制，不到万不得已请不要使用
	 * 
	 * @param str -- 输入不需要任何处理 的对象
	 * @return 原样返回输入对象
	 */
	public static Object ignoretext(Object str){
		if (str != null){
			return str;
		}else{
			return null;
		}
	}
	
	
	
	/**
	 * 先对Object做toString()处理，然后进行escapeJson处理
	 * 
	 * @param jsonobj -- 输入的待转义的Object jsonobj
	 * @return 经过转义的json 字符串
	 */
	public static String escapeJson(Object jsonobj){
		if (jsonobj != null){
			return escapeJson(jsonobj.toString());
		}
		else{
			return null;
		}
		
	}
	
	/**
	 * 不破坏JSON结构的escape函数，只对json结构中name和vaule做escapeHtml处理<br />
	 * 
	 * 返回结果进过jsEncode处理<br />
	 * 
	 * @param jsontext -- 输入的待转义的jsontext
	 * @return	经过转义和jsEncode的json 字符串
	 */
	public static String escapeJsonForJsVar(String jsontext){
		if (jsontext != null)
		{
			return jsEncode(escapeJson(jsontext));
		}
		else{
			return null;
		}
	}
	
	
	/**
	 * 先对Object做toString()处理，然后进行escapeJsonForJs处理
	 * 
	 * @param jsonobj -- 输入的待转义的Object jsonobj
	 * @return 经过转义和jsEncode的json 字符串
	 */
	public static String escapeJsonForJsVar(Object jsonobj){
		if (jsonobj != null){
			return escapeJsonForJsVar(jsonobj.toString());
		}
		else{
			return null;
		}
		
	}
	
}
