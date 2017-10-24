package com.sky.dining.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;


import com.orhanobut.logger.Logger;
import com.sky.dining.BuildConfig;
import com.sky.dining.component.CrashHandler;


import org.xutils.x;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Yngy on 2017-06-28.
 */

public class App extends Application {

    private static App instance;
    private Set<Activity> allActivities;

    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;
    public static float DIMEN_RATE = -1.0F;
    public static int DIMEN_DPI = -1;

    public static synchronized App getInstance() {
        return instance;
    }

    public static String PASSPORT;

    /**
     * 保存通行证
     * @param passport
     */
    public static void savePassPort(String passport){
        PASSPORT=passport;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        //初始化屏幕宽高
        getScreenSize();
        //初始化日志处理框架
        Logger.init(getPackageName()).hideThreadInfo();

        //初始化错误收集
        CrashHandler.init(new CrashHandler(getApplicationContext()));

        //初始化xutils
        initXutils();

    }

    private void initXutils() {
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.LEO_DEBUG);
    }

    public void addActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<Activity>();
        }
        allActivities.add(act);
    }

    public void removeActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    /**
     * 退出
     */
    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    /**
     * 初始化屏幕尺寸信息
     */
    public void getScreenSize() {
        WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        DIMEN_RATE = dm.density / 1.0F;
        DIMEN_DPI = dm.densityDpi;
        SCREEN_WIDTH = dm.widthPixels;
        SCREEN_HEIGHT = dm.heightPixels;
        if (SCREEN_WIDTH > SCREEN_HEIGHT) {
            int t = SCREEN_HEIGHT;
            SCREEN_HEIGHT = SCREEN_WIDTH;
            SCREEN_WIDTH = t;
        }
    }



}
