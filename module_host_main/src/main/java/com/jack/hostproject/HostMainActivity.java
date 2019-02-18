package com.jack.hostproject;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jacklee.hotpatch.libs.JackApkManager;
import com.jacklee.hotpatch.libs.JackUtils;

import java.io.File;

/**
 * by jack
 */
public class HostMainActivity extends AppCompatActivity implements Runnable, Handler.Callback, View.OnClickListener {


    public static final String FIRST_APK_KEY = "first_apk";
    public static final String TWO_APK_KEY = "other_apk";

    private Handler handler;

    private TextView showFont;
    private ProgressBar progressBar;
    private Button openOneApk;
    private Button openTwoApk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_main);

        showFont = (TextView) findViewById(R.id.show_font);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        openOneApk = (Button) findViewById(R.id.open_one_apk);
        openTwoApk = (Button) findViewById(R.id.open_two_apk);

        handler = new Handler(this);
        new Thread(this).start();
    }

    @Override
    public void run() {
        String s = "module_client_one-debug.apk";
        String dexOutPath = "dex_output2";
        File nativeApkPath = JackUtils.getNativeApkPath(getApplicationContext(), s);
        JackApkManager.getInstance().loadApk(FIRST_APK_KEY, nativeApkPath.getAbsolutePath(), dexOutPath, this);

        String s2 = "module_client_two-debug.apk";
        String dexOutPath2 = "dex_output3";
        File nativeApkPath1 = JackUtils.getNativeApkPath(getApplicationContext(), s2);
        JackApkManager.getInstance().loadApk(TWO_APK_KEY, nativeApkPath1.getAbsolutePath(), dexOutPath2, this);

        handler.sendEmptyMessage(0x78);
    }

    @Override
    public boolean handleMessage(Message message) {
        showFont.setText("当前是主宿主apk\n插件apk加载完毕");
        progressBar.setVisibility(View.GONE);
        openOneApk.setVisibility(View.VISIBLE);
        openTwoApk.setVisibility(View.VISIBLE);
        openOneApk.setOnClickListener(this);
        openTwoApk.setOnClickListener(this);
        return false;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.open_one_apk) {
            JackUtils.goActivity(this, FIRST_APK_KEY, null);
        }
        if (v.getId() == R.id.open_two_apk) {
            JackUtils.goActivity(this, TWO_APK_KEY, null);
        }
    }
}
