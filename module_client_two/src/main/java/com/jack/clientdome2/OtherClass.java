package com.jack.clientdome2;

import android.app.Activity;
import android.os.Bundle;

import com.jacklee.hotpatch.libs.JackBaseInterfaceImp;

/**
 *  by jack
 */
public class OtherClass extends JackBaseInterfaceImp {

    @Override
    public void onCreate(Bundle savedInstanceState, Activity activity) {
        super.onCreate(savedInstanceState, activity);

        activity.setContentView(R.layout.activity_other_main);
    }
}
