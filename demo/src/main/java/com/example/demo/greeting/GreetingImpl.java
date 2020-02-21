package com.example.demo.greeting;

import com.example.demo.annotation.Tag;
import org.springframework.stereotype.Component;

@Component
public class GreetingImpl implements Greeting {

    @Override
    @Tag
    public void sayHello(String name) {
        System.out.println("Hello! " + name);
    }
}
