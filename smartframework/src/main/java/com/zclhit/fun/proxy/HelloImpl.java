package com.zclhit.fun.proxy;

public class HelloImpl implements Hello{
    public void say(String name) {
        System.out.println("Hello! " + name);
    }
}