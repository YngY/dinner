package com.sky.dining.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.sky.dining.R;
import com.sky.dining.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolBar;
    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;

    @Override
    protected int getLayout() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initEventAndData() {
        setToolBar(mToolBar);
        mToolbarTitle.setText("设置");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
