package com.simple.mvpdemo.user.presenter;

import android.content.Context;
import android.os.Handler;

import com.simple.mvpdemo.user.interactor.LoginInteractorImpl;
import com.simple.mvpdemo.user.interactor.OnLoginListener;
import com.simple.mvpdemo.user.model.UserBO;
import com.simple.mvpdemo.user.view.ILoginView;
import com.simple.mvpdemo.util.InfoSaveUtil;


/**
 * 登录操作类
 *
 * @author ${Simple}
 * @date ${2016/7/1}
 */
public class LoginPresenterImpl {

    private LoginInteractorImpl userModel;
    private ILoginView loginView;
    private Handler handler = new Handler();

    public LoginPresenterImpl(ILoginView loginView) {
        this.userModel = new LoginInteractorImpl();
        this.loginView = loginView;
    }

    public void login(final Context context) {

        userModel.login(loginView.getLoginName(), loginView.getPassWord(), new OnLoginListener() {

            //登录成功
            @Override
            public void loginSuccess(final UserBO userBO) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        InfoSaveUtil.getInstance(context).setInfo(loginView.getLoginName(),
                                loginView.getPassWord());
                        loginView.showSuccess(userBO);
                    }
                });
            }

            //登录失败
            @Override
            public void loginFail() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.showFail();
                    }
                });
            }

        }, context);
    }
}
