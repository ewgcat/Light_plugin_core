package com.jack.hostproject;

import com.jacklee.hotpatch.libs.JackHostBaseActivity;

/**
 *  by jack
 */
public class ApkActivity extends JackHostBaseActivity {


    @Override
    public String getApkKeyName() {
        return HostMainActivity.FIRST_APK_KEY;
    }

    @Override
    public String getClassTag() {
        return null;
    }
}
