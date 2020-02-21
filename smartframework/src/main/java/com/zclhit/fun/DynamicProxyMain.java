package com.zclhit.fun;

import com.zclhit.fun.proxy.DynamicProxy;
import com.zclhit.fun.proxy.Hello;
import com.zclhit.fun.proxy.HelloImpl;

public class DynamicProxyMain {
    public static void main(String[] args) {
        Hello hello = new HelloImpl();

        DynamicProxy dynamicProxy = new DynamicProxy(hello);

        Hello helloProxy = dynamicProxy.getProxy();

        helloProxy.say("JDK动态代理");
    }
}
