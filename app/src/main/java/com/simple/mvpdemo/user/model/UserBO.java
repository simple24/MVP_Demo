package com.simple.mvpdemo.user.model;

/**
 * 用户类
 *
 * @author ${Simple}
 * @date ${2016/7/1}
 */
public class UserBO {

    private String loginName;   //登录用户名
    private String password;    //登录密码

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
