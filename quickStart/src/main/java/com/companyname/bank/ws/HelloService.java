package com.companyname.bank.ws;

import javax.jws.WebService;

@WebService
public interface HelloService {
    String say(String name);
}
