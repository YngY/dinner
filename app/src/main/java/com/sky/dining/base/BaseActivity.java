/*
 * Copyright (C) 2015 Drakeet <drakeet.me@gmail.com>
 *
 * This file is part of Meizhi
 *
 * Meizhi is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Meizhi is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Meizhi.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.sky.dining.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.sky.dining.R;
import com.sky.dining.app.App;
import com.sky.dining.util.LogUtil;

import butterknife.ButterKnife;



/**
 * Created by drakeet on 8/9/15.
 */
public abstract class BaseActivity extends AppCompatActivity {



    protected Activity mContext;
    protected String TAG;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        mContext = this;
        TAG = this.getClass().getSimpleName();


        App.getInstance().addActivity(this);
        initEventAndData();
    }


    protected void login() {

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();

        App.getInstance().removeActivity(mContext);


    }



    /**
     * 加载布局文件
     *
     * @return 资源id
     */
    protected abstract int getLayout();

    /**
     * 根据传入的类(class)打开指定的activity
     *
     * @param pClass
     */
    protected void startThActivity(Class<?> pClass) {
        Intent _Intent = new Intent();
        _Intent.setClass(this, pClass);
        startActivity(_Intent);
        overridePendingTransition(R.anim.trans_next_in, R.anim.trans_next_out);
    }

    protected void startThActivityByIntent(Intent pIntent) {
        startActivity(pIntent);
        overridePendingTransition(R.anim.trans_next_in, R.anim.trans_next_out);
    }

    /**
     * 获取数据
     */
    protected abstract void initEventAndData();


    protected void setToolBar(Toolbar toolbar) {

        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.finish();
            }
        });
    }

    protected void setToolBarHideBack(Toolbar toolbar) {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }




}
