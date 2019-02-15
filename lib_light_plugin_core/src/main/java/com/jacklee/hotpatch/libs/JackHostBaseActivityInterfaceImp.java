package com.jacklee.hotpatch.libs;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;

/**
 *  by jack
 */
public class JackHostBaseActivityInterfaceImp implements JackHostBaseActivityInterface {

    private Activity activity;
    private JackApkHelper apkHelper;

    @Override
    public void init(Activity activity) {
        this.activity = activity;

//        LinearLayout linearLayout = new LinearLayout(activity);
//        linearLayout.setOrientation(LinearLayout.VERTICAL);
//        linearLayout.setId(android.R.id.primary);
//
//        activity.setContentView(linearLayout);
    }

    @Override
    public boolean isInit() {
        if (apkHelper!=null)
            return true;
        return false;
    }

    public Class<?> getProxy(String keyName, String classTag){
        if (classTag==null)
        {
            classTag= JackConfig.ROOT_CLASS_NAME;
        }
        apkHelper = JackApkManager.getInstance().getHelper(keyName);
        Class<?> classById = apkHelper.getClassById(classTag);
        return classById;
    }

    @Override
    public JackBaseInterface getBaserProxy(String keyName, String classTag) {
        Class<?> proxy = getProxy(keyName, classTag);
        JackBaseInterface o =null;
        try {
            o = (JackBaseInterface) proxy.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public Resources getResources() {
        return apkHelper.getResources();
    }

    @Override
    public AssetManager getAssets() {
        return apkHelper.getResources().getAssets();
    }

    @Override
    public ClassLoader getClassLoader() {
        return apkHelper.getDexClassLoader();
    }

    @Override
    public Resources.Theme getTheme() {
        return apkHelper.getTheme();
    }

    @Override
    public PackageInfo getPackageInfo() {
        return apkHelper.getPackageInfo();
    }

}
