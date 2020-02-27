package com.companyname.bank.ws;

import org.springframework.stereotype.Component;

import javax.jws.WebService;

@WebService
@Component
public class HelloServiceImpl implements HelloService{
    @Override
    public String say(String name) {
        return "hello : " + name;
    }
}
