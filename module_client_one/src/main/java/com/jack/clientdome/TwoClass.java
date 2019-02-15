package com.jack.clientdome;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jacklee.hotpatch.libs.JackBaseInterfaceImp;

/**
 *  by jack
 */
public class TwoClass extends JackBaseInterfaceImp {

    @Override
    public void onCreate(Bundle savedInstanceState, Activity activity) {
        super.onCreate(savedInstanceState, activity);

        activity.setContentView(R.layout.activity_client_main);

        TextView showFont= (TextView) activity.findViewById(R.id.showFont);
        activity.findViewById(R.id.jump).setVisibility(View.GONE);

        showFont.setText("当前是module_client_one-release.apk的TwoClass");
    }
}
