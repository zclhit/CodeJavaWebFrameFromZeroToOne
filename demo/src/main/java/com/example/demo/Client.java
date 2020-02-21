package com.example.demo;

import com.example.demo.advice.GreetingAfterAdvice;
import com.example.demo.advice.GreetingAroundAdvice;
import com.example.demo.advice.GreetingBeforeAdvice;
import com.example.demo.advice.GreetingBeforeAndAfterAdvice;
import com.example.demo.advice.GreetingThrowAdvice;
import com.example.demo.greeting.Greeting;
import com.example.demo.greeting.GreetingImpl;
import org.springframework.aop.framework.ProxyFactory;

public class Client {
    public static void main(String[] args) {
        // 编程式实现AOP：前置增强，后置增强，环绕式增强
        beforeAndAfter();
//        beforeAndAfterSameTime();
//        aroundAdvice();
    }

    private static void aroundAdvice() {
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(new GreetingImpl()); // 注入目标对象
        factory.addAdvice(new GreetingAroundAdvice());

        Greeting greeting = (Greeting) factory.getProxy();

        greeting.sayHello("Baby");
    }

    private static void beforeAndAfterSameTime() {
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(new GreetingImpl()); // 注入目标对象
        factory.addAdvice(new GreetingBeforeAndAfterAdvice());

        Greeting greeting = (Greeting) factory.getProxy();

        greeting.sayHello("Rose");
    }

    private static void beforeAndAfter() {
        ProxyFactory factory = new ProxyFactory(); // 创建代理工厂
        factory.setTarget(new GreetingImpl()); // 注入目标对象
        factory.addAdvice(new GreetingBeforeAdvice()); // 添加前置增强
        factory.addAdvice(new GreetingAfterAdvice()); // 添加后置增强
        factory.addAdvice(new GreetingThrowAdvice()); // 添加抛出增强

        Greeting greeting = (Greeting) factory.getProxy();

        greeting.sayHello("Jack");
    }
}
