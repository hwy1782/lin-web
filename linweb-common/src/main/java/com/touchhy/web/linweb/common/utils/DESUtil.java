package com.touchhy.web.linweb.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class DESUtil {
	private static DesEncrypter des = new DesEncrypter("linweb");
	public static String encrypt(String original){
		String en = des.encrypt(original);
		try {
			return URLEncoder.encode(en, "GBK");
		} catch (UnsupportedEncodingException e) {
		}
		return "";
	}
	public static String decrypt(String original){
		String decoder;
		try {
			decoder = URLDecoder.decode(original, "GBK");
			return des.decrypt(decoder);
		} catch (UnsupportedEncodingException e) {
		}
		return "";
	}
	public static String byte2hex(byte[] b) {    
        String hs = "";    
        String stmp = "";    
        for (int i = 0; i < b.length; i++) {    
            stmp = Integer.toHexString(b[i] & 0xFF);    
            if (stmp.length() == 1) {    
                hs += "0" + stmp;    
            }    
            else {    
                hs += stmp;    
            }    
        }    
        return hs.toUpperCase();    
    }   
       
    public static byte[] hex2byte(String hex) throws IllegalArgumentException {    
        if (hex.length() % 2 != 0) {    
            throw new IllegalArgumentException();    
        }    
        char[] arr = hex.toCharArray();    
        byte[] b = new byte[hex.length() / 2];    
        for (int i = 0, j = 0, l = hex.length(); i < l; i++, j++) {    
            String swap = "" + arr[i++] + arr[i];    
            int byteint = Integer.parseInt(swap, 16) & 0xFF;    
            b[j] = new Integer(byteint).byteValue();    
        }    
        return b;    
    }   
}
