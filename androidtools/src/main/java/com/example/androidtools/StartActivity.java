package com.example.androidtools;

import android.content.Context;
import android.content.Intent;

/**
 * Created by zhaohuiyan on 2018/1/2.
 */

public class StartActivity {
    private Context context;
    private static class LazyHolder {
        private static StartActivity INSTANCE = new StartActivity();
    }

    public static StartActivity getInstance() {
        return LazyHolder.INSTANCE;
    }

}
