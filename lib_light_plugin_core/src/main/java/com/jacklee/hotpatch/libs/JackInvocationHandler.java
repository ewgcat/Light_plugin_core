package com.jacklee.hotpatch.libs;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  by jack
 */
public class JackInvocationHandler implements InvocationHandler {

    public static final String tag="JackInvocationHandler";
    private Object obj;

    public Object bind(Class<?> name){
        Log.i(tag, "interface name="+name);
        obj = JackUtils.getObj(name.getName(), getClass().getClassLoader());
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }


    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Log.i(tag, "method name=="+ method.getName());
        Object invoke = method.invoke(obj, objects);
        return invoke;
    }


}
