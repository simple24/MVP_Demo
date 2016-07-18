package com.simple.mvpdemo.user.view;

import com.simple.mvpdemo.user.model.UserBO;

/**
 * View实现接口
 *
 * @author ${Simple}
 * @date ${2016/7/1}
 */
public interface ILoginView {

    /**
     * 获取用户名
     */
    String getLoginName();

    /**
     * 获取用户密码
     */
    String getPassWord();

    /**
     * 登录成功
     *
     * @param userBO 用户信息
     */
    void showSuccess(UserBO userBO);

    /**
     * 登录失败
     */
    void showFail();


}
