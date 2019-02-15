package com.jack.clientdome;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jacklee.hotpatch.libs.JackBaseInterfaceImp;
import com.jacklee.hotpatch.libs.JackUtils;

/**
 *  by jack
 */
public class TestClass extends JackBaseInterfaceImp {

    private Activity activity;

    @Override
    public void onCreate(Bundle savedInstanceState, final Activity activity) {
        this.activity=activity;

        activity.setContentView(R.layout.activity_client_main);

        activity.findViewById(R.id.jump).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JackUtils.goActivity(activity,"first_apk", "two_class");
            }
        });

        ImageView imageView= (ImageView) activity.findViewById(R.id.img_view);
        imageView.setVisibility(View.VISIBLE);
        Glide.with(activity).load("http://cdn.hktd01e.td98.com/rxputao.com/skin/sever-2.jpg").into( imageView);

    }
}
