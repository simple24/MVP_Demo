package com.simple.mvpdemo.user.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.simple.mvpdemo.R;
import com.simple.mvpdemo.user.model.UserBO;
import com.simple.mvpdemo.user.presenter.LoginPresenterImpl;
import com.simple.mvpdemo.util.InfoSaveUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登录界面类
 *
 * @author ${Simple}
 * @date ${2016/7/1}
 */
public class LoginActivity extends AppCompatActivity implements ILoginView {

    @BindView(R.id.edt_phone_number)
    com.simple.mvpdemo.ui.OneKeyClearEditText phoneNumberEdt;
    @BindView(R.id.edt_login_password)
    com.simple.mvpdemo.ui.OneKeyClearEditText loginPasswordEdt;
    @BindView(R.id.btn_login)
    Button loginBtn;

    private LoginPresenterImpl loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenterImpl(this);

        phoneNumberEdt.setText(InfoSaveUtil.getInstance(this).getLoginName());
        loginPasswordEdt.setText(InfoSaveUtil.getInstance(this).getPassword());

    }

    @OnClick(R.id.btn_login)
    public void onClick() {
        loginPresenter.login(this);
    }

    @Override
    public String getLoginName() {
        return phoneNumberEdt.getText().toString();
    }

    @Override
    public String getPassWord() {
        return loginPasswordEdt.getText().toString();
    }

    @Override
    public void showSuccess(UserBO userBO) {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFail() {
        Toast.makeText(this, "用户名或者密码错误", Toast.LENGTH_SHORT).show();
    }
}
