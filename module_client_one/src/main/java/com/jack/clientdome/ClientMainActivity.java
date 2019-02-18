package com.jack.clientdome;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jacklee.hotpatch.libs.JackBaseInterface;
import com.jacklee.hotpatch.libs.JackClientBaseActivity;

/**
 *  by jack
 */
@Route(path = "/one/main")
public class ClientMainActivity extends JackClientBaseActivity {

    @Override
    public JackBaseInterface getProxyBase() {
        return new TestClass();
    }


}
