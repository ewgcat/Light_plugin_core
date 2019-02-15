package com.jacklee.hotpatch.libs;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;

/**
 *  by jack
 */
public class JackHostActivityHelper {

    JackHostBaseActivityInterface hostBaseActivityInterface;

    public JackHostActivityHelper(Activity activity) {
        hostBaseActivityInterface= (JackHostBaseActivityInterface) new JackInvocationHandler().bind(JackHostBaseActivityInterface.class);
        hostBaseActivityInterface.init(activity);
    }

    public boolean isInit(){
        return hostBaseActivityInterface.isInit();
    }

    public JackBaseInterface getBaserProxy(String keyName, String classTag){
        return hostBaseActivityInterface.getBaserProxy(keyName, classTag);
    }

    public Resources getResources(){
        return hostBaseActivityInterface.getResources();
    }

    public AssetManager getAssets() {
        return hostBaseActivityInterface.getAssets();
    }

    public ClassLoader getClassLoader() {
        return hostBaseActivityInterface.getClassLoader();
    }

    public Resources.Theme getTheme(){
        return hostBaseActivityInterface.getTheme();
    }

    public PackageInfo getPackageInfo(){
        return hostBaseActivityInterface.getPackageInfo();
    }


}
