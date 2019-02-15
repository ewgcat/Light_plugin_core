package com.jacklee.hotpatch.libs;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;

/**
 *  by jack
 */
public interface JackHostBaseActivityInterface {

    void init(Activity activity);

    boolean isInit();

    JackBaseInterface getBaserProxy(String keyName, String classTag);

    Resources getResources();

    AssetManager getAssets();

    ClassLoader getClassLoader();

    Resources.Theme getTheme();

    PackageInfo getPackageInfo();



}
