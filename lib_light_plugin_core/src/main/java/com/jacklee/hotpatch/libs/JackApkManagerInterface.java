package com.jacklee.hotpatch.libs;

import android.content.Context;

/**
 *  by jack
 */
public interface JackApkManagerInterface {

    void init();

    void load(String keyName, String apkPath, String dexOutPath, Context context);

    JackApkHelper get(String keyName);

}
