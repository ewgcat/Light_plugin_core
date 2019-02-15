package com.jacklee.hotpatch.libs;

import android.content.Context;

import java.util.HashMap;

/**
 *  by jack
 */
public class JackApkManagerInterfaceImp implements JackApkManagerInterface {

    private HashMap<String, JackApkHelper> apkHelperHashMap;

    @Override
    public void init() {
        apkHelperHashMap=new HashMap<>();
    }

    @Override
    public void load(String keyName, String apkPath, String dexOutPath, Context context) {
        JackApkHelper jackleeApkHelper = new JackApkHelper(apkPath, dexOutPath, context);
        apkHelperHashMap.put(keyName, jackleeApkHelper);
    }

    @Override
    public JackApkHelper get(String keyName) {
        return apkHelperHashMap.get(keyName);
    }
}
