package com.example.demo.advice;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class GreetingThrowAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, Exception e) {
        System.out.println("-----Throw Exception -------");
        System.out.println("Target class: " + target.getClass().getName());
        System.out.println("Method name: " + method.getName());
        System.out.println("Exception message: " + e.getMessage());
        System.out.println("----------------------------");
    }
}
