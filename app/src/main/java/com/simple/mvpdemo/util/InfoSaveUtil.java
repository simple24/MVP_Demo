package com.simple.mvpdemo.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 信息保存工具类
 *
 * @author ${Simple}
 * @date ${2016/7/1}
 */
public class InfoSaveUtil {

    private static InfoSaveUtil infoSaveUtils = null;
    private SharedPreferences sharedPreferences;

    private static final String INFO_NAME = "infoName";     //SharedPreferences名
    private static final String LOGIN_NAME = "loginName";   //用户名key
    private static final String PASSWORD = "password";      //密码key

    public InfoSaveUtil(Context context) {
        sharedPreferences = context.getSharedPreferences(INFO_NAME, Context.MODE_PRIVATE);
    }

    /**
     * 单例模式下，返回工具类实例
     *
     * @param context
     */
    public static synchronized InfoSaveUtil getInstance(Context context){
        if (infoSaveUtils == null) {
            infoSaveUtils = new InfoSaveUtil(context);
        }
        return infoSaveUtils;
    }

    /**
     * 保存用户信息
     *
     * @param loginName
     * @param password
     */
    public void setInfo(String loginName, String password){

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(LOGIN_NAME, loginName);
        editor.putString(PASSWORD, MD5Util.encode(password));
        editor.commit();

    }

    /**
     * 获取用户名
     */
    public String getLoginName(){

        String loginName = sharedPreferences.getString(LOGIN_NAME, "");
        return loginName;

    }

    /**
     * 获取用户密码
     */
    public String getPassword(){

        String password = sharedPreferences.getString(PASSWORD, "");
        return password;

    }
}
