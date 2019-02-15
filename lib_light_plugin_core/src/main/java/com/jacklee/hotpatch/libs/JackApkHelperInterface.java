package com.jacklee.hotpatch.libs;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Resources;

import dalvik.system.DexClassLoader;

/**
 *  by jack
 */
public interface JackApkHelperInterface {

    void init(String apkPath, String dexOutPath, Context context);

    Class<?> getClassById(String keyName);

    PackageInfo getPackageInfo();

    DexClassLoader getDexClassLoader();

    Resources getResources();

    Resources.Theme getTheme();

}
