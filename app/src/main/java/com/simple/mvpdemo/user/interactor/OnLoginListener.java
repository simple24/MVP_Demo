package com.simple.mvpdemo.user.interactor;


import com.simple.mvpdemo.user.model.UserBO;

/**
 * 用户登录监听接口
 *
 * @author ${Simple}
 * @date ${2016/7/1}
 */
public interface OnLoginListener {

    /**
     * 登录成功
     *
     * @param userBO 用户
     */
    void loginSuccess(UserBO userBO);

    /**
     * 登录失败
     */
    void loginFail();

}
