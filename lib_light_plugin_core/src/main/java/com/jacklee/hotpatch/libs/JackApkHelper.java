package com.jacklee.hotpatch.libs;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Resources;

import dalvik.system.DexClassLoader;

/**
 *  by jack
 */
public class JackApkHelper {

    JackApkHelperInterface apkHelperInterface;

    public JackApkHelper(String apkPath, String dexOutPath, Context context) {
        apkHelperInterface= (JackApkHelperInterface) new JackInvocationHandler().bind(JackApkHelperInterface.class);
        apkHelperInterface.init(apkPath,dexOutPath,context);
    }

    public Class<?> getClassById(String keyName){
        return apkHelperInterface.getClassById(keyName);
    }

    public PackageInfo getPackageInfo() {
        return apkHelperInterface.getPackageInfo();
    }

    public DexClassLoader getDexClassLoader() {
        return apkHelperInterface.getDexClassLoader();
    }

    public Resources getResources() {
        return apkHelperInterface.getResources();
    }

    public Resources.Theme getTheme(){
        return apkHelperInterface.getTheme();
    }

}
