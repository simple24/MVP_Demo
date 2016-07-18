package com.simple.mvpdemo.util;

import java.security.MessageDigest;

/**
 * 密码加密工具类
 *
 * @author ${Simple}
 * @date ${2016/7/1}
 */
public class MD5Util {

    /**
     * md5加密方法
     *
     * @param password
     * @return
     */
    public static String encode(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] results = digest.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : results) {
                int number = b & 0xff;
                String hex = Integer.toHexString(number);
                if (hex.length() == 1) {
                    sb.append("0");
                }
                sb.append(hex);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}
