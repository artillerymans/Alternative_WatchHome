package com.android.hoinnet.alternative.watchhome;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * Created by zhuzhiwei on 17-11-22.
 */

public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
