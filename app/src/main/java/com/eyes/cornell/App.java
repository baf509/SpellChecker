package com.eyes.cornell;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

public class App extends Application {
    private static Context context;
    private static Activity activity;

    public void onCreate() {
        super.onCreate();
        App.context = getApplicationContext();
    }

    public synchronized static Context getAppContext() {
        return App.context;
    }

    public static void setCurrentActivity(Activity currentActivity) {
        activity = currentActivity;
    }

    public static Activity currentActivity() {
        return activity;
    }

}