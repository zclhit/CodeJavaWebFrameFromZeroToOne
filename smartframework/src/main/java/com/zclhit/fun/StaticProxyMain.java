package com.zclhit.fun;

import com.zclhit.fun.proxy.Hello;
import com.zclhit.fun.proxy.HelloProxy;

public class StaticProxyMain {
    public static void main(String[] args) {
        Hello helloProxy = new HelloProxy();
        helloProxy.say("静态代理");
    }
}
