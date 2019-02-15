package com.jacklee.hotpatch.libs;

import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;

/**
 *  by jack
 */
public abstract class JackHostBaseActivity extends AppCompatActivity {

    private JackHostActivityHelper hostActivityHelper;
    private JackBaseInterface proxyClass;
    private String apkName;
    private String classTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getIntentParm();
        hostActivityHelper = new JackHostActivityHelper(this);
        proxyClass = hostActivityHelper.getBaserProxy(apkName, classTag);
        JackLayoutInflaterFactory jackleeLayoutInflaterFactory = new JackLayoutInflaterFactory();
        jackleeLayoutInflaterFactory.setHostActivityHelper(hostActivityHelper);
        LayoutInflaterCompat.setFactory(getLayoutInflater(),jackleeLayoutInflaterFactory);
        super.onCreate(savedInstanceState);
        proxyClass.onCreate(savedInstanceState,this);
    }

    private void getIntentParm() {
        apkName = getIntent().getStringExtra(JackConfig.APK_NAME);
        classTag=getIntent().getStringExtra(JackConfig.CLASS_TAG);
        if (apkName==null)
            apkName = getApkKeyName();

        if (classTag==null)
            classTag = getClassTag();
    }

    public abstract String getApkKeyName();
    public abstract String getClassTag();

    @Override
    protected void onDestroy() {
        proxyClass.onDestroy();
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
        proxyClass.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        proxyClass.onResume();
    }

    @Override
    protected void onPause() {
        proxyClass.onPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        proxyClass.onStop();
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        proxyClass.onRestart();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        proxyClass.onNewIntent(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        proxyClass.onActivityResult(requestCode,resultCode,data);
    }

    @Override
    public void onBackPressed() {
        proxyClass.onBackPressed();
        super.onBackPressed();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        proxyClass.onSaveInstanceState(outState);
    }

    @Override
    public Resources getResources() {
        if (hostActivityHelper != null && hostActivityHelper.isInit()) {
            return hostActivityHelper.getResources();
        }
        return super.getResources();
    }

    @Override
    public AssetManager getAssets() {
        if (hostActivityHelper != null && hostActivityHelper.isInit()) {
            return hostActivityHelper.getAssets();
        }
        return super.getAssets();
    }

    @Override
    public ClassLoader getClassLoader() {
        if (hostActivityHelper != null && hostActivityHelper.isInit()) {
            return hostActivityHelper.getClassLoader();
        }
        return super.getClassLoader();
    }

    @Override
    public Resources.Theme getTheme() {
        if (hostActivityHelper!=null && hostActivityHelper.isInit())
        {
            return hostActivityHelper.getTheme();
        }
        return super.getTheme();
    }

}
