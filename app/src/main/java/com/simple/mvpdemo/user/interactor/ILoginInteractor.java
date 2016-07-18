package com.simple.mvpdemo.user.interactor;

import android.content.Context;

/**
 * 用户登录接口
 *
 * @author ${Simple}
 * @date ${2016/7/1}
 */
public interface ILoginInteractor {

    /**
     * 登录
     *
     * @param loginName     登录名
     * @param password      密码
     * @param loginListener 回调监听器
     * @param context       上下文
     */
    void login(String loginName, String password, OnLoginListener loginListener, Context context);

}
