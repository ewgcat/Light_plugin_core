package com.jack.clientdome;

import com.jacklee.hotpatch.libs.JackBaseInterface;
import com.jacklee.hotpatch.libs.JackClientBaseActivity;

/**
 *  by jack
 */
public class ClientMainActivity extends JackClientBaseActivity {

    @Override
    public JackBaseInterface getProxyBase() {
        return new TestClass();
    }


}
