package com.jacklee.hotpatch.libs;

import android.content.Context;

/**
 *  by jack
 */
public class JackApkManager {

    private static JackApkManager instance = null;
    private JackApkManagerInterface apkManagerInterface;

    private JackApkManager() {
        apkManagerInterface = (JackApkManagerInterface) new JackInvocationHandler().bind(JackApkManagerInterface.class);
        apkManagerInterface.init();
    }

    public static JackApkManager getInstance() {
        if (instance == null) {
            synchronized (JackApkManager.class) {
                if (instance == null) {
                    instance = new JackApkManager();
                }
            }
        }
        return instance;
    }

    public void loadApk(String keyName, String apkPath, String dexOutPath, Context context) {
        apkManagerInterface.load(keyName,apkPath,dexOutPath,context);
    }

    public JackApkHelper getHelper(String keyName) {
        return apkManagerInterface.get(keyName);
    }


}
