package com.zclhit.fun.proxy;

public class HelloProxy implements Hello{
    private Hello hello;

    public HelloProxy() {
        this.hello = new HelloImpl();
    }

    public void say(String name) {
        before();
        hello.say(name);
        after();
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }
}
