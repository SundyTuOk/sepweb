package com.sf.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.Cookie;

import org.apache.log4j.Logger;

public class CommonUtils {
	
	private static Logger logger = Logger.getLogger(CommonUtils.class);
	
	/**
     * 生成32位md5码
     * @param password
     * @return
     */
    public static String md5Password(String password) {

        try {
            // 得到一个信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(password.getBytes());
            StringBuffer buffer = new StringBuffer();
            // 把每一个byte 做一个与运算 0xff;
            for (byte b : result) {
                // 与运算
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }

            // 标准的md5加密后的结果
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
        	logger.error(e+"\nMD5加密失败");
            return null;
        }

    }
    
    /**
     * 本程序规定程序中所有cookie对象从这里取，方便统一管理设置
     * @return
     */
    public static Cookie getNewCookie(String cookieName,String cookieValue){
    	Cookie cookie = new Cookie(cookieName, cookieValue);
    	cookie.setMaxAge(60 * 60 * 24 * 10);//10天
    	return cookie;
    }
}
