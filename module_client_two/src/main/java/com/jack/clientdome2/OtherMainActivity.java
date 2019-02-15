package com.jack.clientdome2;

import com.jacklee.hotpatch.libs.JackBaseInterface;
import com.jacklee.hotpatch.libs.JackClientBaseActivity;

/**
 *  by jack
 */
public class OtherMainActivity extends JackClientBaseActivity {

    @Override
    public JackBaseInterface getProxyBase() {
        return new OtherClass();
    }
}
