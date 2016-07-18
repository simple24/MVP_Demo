package com.simple.mvpdemo.user.interactor;

import android.content.Context;

import com.simple.mvpdemo.user.model.UserBO;
import com.simple.mvpdemo.util.InfoSaveUtil;

/**
 * 登录实现类
 *
 * @author ${Simple}
 * @date ${2016/7/1}
 */
public class LoginInteractorImpl implements ILoginInteractor {

    @Override
    public void login(final String loginname, final String password, final OnLoginListener
            loginListener, final Context context) {

        //采用子线程模拟耗时登录
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //进行数据判断
                if ("18826233787".equals(loginname) && ("123456".equals(password) ||
                        InfoSaveUtil.getInstance(context).getPassword().equals(password))) {

                    UserBO userBO = new UserBO();
                    userBO.setLoginName(loginname);
                    userBO.setPassword(password);

                    loginListener.loginSuccess(userBO);
                } else {
                    loginListener.loginFail();
                }
            }
        }).start();
    }
}
