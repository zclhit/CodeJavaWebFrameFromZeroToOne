package com.example.demo;

import com.example.demo.advice.GreetingAfterAdvice;
import com.example.demo.advice.GreetingBeforeAdvice;
import com.example.demo.greeting.Greeting;
import com.example.demo.greeting.GreetingImpl;
import org.springframework.aop.framework.ProxyFactory;

public class Client {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory(); // 创建代理工厂
        factory.setTarget(new GreetingImpl()); // 注入目标对象
        factory.addAdvice(new GreetingBeforeAdvice()); // 添加前置增强
        factory.addAdvice(new GreetingAfterAdvice()); // 添加后置增强

        Greeting greeting = (Greeting) factory.getProxy();

        greeting.sayHello("Jack");
    }
}
