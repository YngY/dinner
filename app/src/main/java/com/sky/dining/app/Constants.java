package com.sky.dining.app;

import android.os.Environment;

import java.io.File;

/**
 * Created by codeest on 2016/8/3.
 */
public class Constants {


    //================= PATH ====================

    public static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "pda" ;

    public static final String PATH_SDCARD_VIDEO=PATH_SDCARD+ File.separator + "video";
    public static final String PATH_SDCARD_VOICE=PATH_SDCARD+ File.separator + "vioce";
    public static final String PATH_SDCARD_IMAGE=PATH_SDCARD+ File.separator + "img";
    public static final String PATH_SDCARD_TXT=PATH_SDCARD+ File.separator + "txt";
    //================= PREFERENCE ====================

    public static final String SP_NIGHT_MODE = "night_mode";

    public static final String SP_NO_IMAGE = "no_image";

    public static final String SP_AUTO_CACHE = "auto_cache";

    public static final String SP_CURRENT_ITEM = "current_item";

    public static final String SP_LIKE_POINT = "like_point";

    public static final String SP_HTTP_HOST = "http_host";

    public static final String SP_HTTP_UUID = "http_uuid";

    //==================== HTTP ========================
    public static final String KEY_API = "";

    public static final String HTTP_HOST="http://cqkd.uicp.cn:5051";
    public static final String HTTP_LOGIN_DOMAIN="/jit/pda/login.xm";

    public static final String HTTP_TERMINAL="PDA-1";


    public static final String HTTP_KEY_ACCONT="account";
    public static final String HTTP_KEY_PWD="password";
    public static final String HTTP_KEY_TERMINAL="terminal";
    public static final String HTTP_KEY_PASSPORT="j_passport";

    public static final String HTTP_KEY_ID="id";

    public static final String HTTP_KEY_BARCODE="barcode";



}
