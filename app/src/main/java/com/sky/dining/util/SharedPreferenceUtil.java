package com.sky.dining.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.sky.dining.app.App;
import com.sky.dining.app.Constants;


/**
 * Created by codeest on 16/8/31.
 */

public class SharedPreferenceUtil {




    private static final String SHAREDPREFERENCES_NAME = "my_sp";

    public static SharedPreferences getAppSp() {
        return App.getInstance().getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
    }



    public static String getHost() {
        return getAppSp().getString(Constants.SP_HTTP_HOST, Constants.HTTP_HOST);
    }

    public static void setHost(String host) {
        getAppSp().edit().putString(Constants.SP_HTTP_HOST, host).commit();
    }


    public static String getUUID() {
        return getAppSp().getString(Constants.SP_HTTP_UUID, Constants.HTTP_TERMINAL);
    }

    public static void setUUID(String uuid) {
        getAppSp().edit().putString(Constants.SP_HTTP_UUID, uuid).commit();
    }


}
