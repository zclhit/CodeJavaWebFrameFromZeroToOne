package com.zclhit.fun;

import com.zclhit.fun.proxy.CGLibProxy;
import com.zclhit.fun.proxy.Hello;
import com.zclhit.fun.proxy.HelloImpl;

public class CGLibProxyMain {
    public static void main(String[] args) {
        CGLibProxy cgLibProxy = new CGLibProxy();
        Hello helloProxy = cgLibProxy.getProxy(HelloImpl.class);
        helloProxy.say("CGLib动态代理");
    }
}
