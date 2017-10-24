package com.sky.dining.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.sky.dining.R;
import com.sky.dining.base.BaseActivity;
import com.sky.dining.util.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.login_username)
    EditText mLoginUsername;
    @BindView(R.id.login_password)
    EditText mLoginPassword;
    @BindView(R.id.login_btnSignin)
    Button mLoginBtn;




    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initEventAndData() {

    }


    @OnClick(R.id.login_btnSignin)
    public void onViewClicked() {
        if(TextUtils.isEmpty(mLoginUsername.getText().toString())){
            ToastUtil.shortShow("请输入用户名");
            return;
        }

        if(TextUtils.isEmpty(mLoginPassword.getText().toString())){
            ToastUtil.shortShow("请输入密码");
            return;
        }

        startThActivity(MainActivity.class);

    }
}
